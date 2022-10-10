package com.atguigu.yygh.common.utils;

import com.github.binarywang.utils.qrcode.BufferedImageLuminanceSource;
import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class QrcodeUtils {
    private static final int DEFAULT_LENGTH = 400;// 生成二维码的默认边长，因为是正方形的，所以高度和宽度一致
    private static final String FORMAT = "jpg";// 生成二维码的格式

    /**
     * 根据内容生成二维码数据
     *
     * @param content 二维码文字内容[为了信息安全性，一般都要先进行数据加密]
     * @param length  二维码图片宽度和高度
     */
    private static BitMatrix createQrcodeMatrix(String content, int length) {
        Map<EncodeHintType, Object> hints = Maps.newEnumMap(EncodeHintType.class);
        // 设置字符编码
        hints.put(EncodeHintType.CHARACTER_SET, Charsets.UTF_8.name());
        // 指定纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

        try {
            return new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, length, length, hints);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据指定边长创建生成的二维码，允许配置logo属性
     *
     * @param content  二维码内容
     * @param length   二维码的高度和宽度
     * @param logoFile logo 文件对象，可以为空
     * @return 二维码图片的字节数组
     */
    public static byte[] createQrcode(String content, int length, File logoFile) {
        if (logoFile != null && !logoFile.exists()) {
            throw new IllegalArgumentException("请提供正确的logo文件！");
        }

        BitMatrix qrCodeMatrix = createQrcodeMatrix(content, length);
        if (qrCodeMatrix == null) {
            return null;
        }
        try {
            File file = Files.createTempFile("qrcode_", "." + FORMAT).toFile();

//			MatrixToImageWriter.writeToFile(qrCodeMatrix, FORMAT, file);
            MatrixToImageWriter.writeToPath(qrCodeMatrix, FORMAT, Paths.get(file.getAbsolutePath()));
            if (logoFile != null) {
                // 添加logo图片, 此处一定需要重新进行读取，而不能直接使用二维码的BufferedImage 对象
                BufferedImage img = ImageIO.read(file);
                overlapImage(img, FORMAT, file.getAbsolutePath(), logoFile);
            }

            return toByteArray(file);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 创建生成默认高度(400)的二维码图片 可以指定是否贷logo
     *
     * @param content  二维码内容
     * @param logoFile logo 文件对象，可以为空
     * @return 二维码图片的字节数组
     */
    public static byte[] createQrcode(String content, File logoFile) {
        return createQrcode(content, DEFAULT_LENGTH, logoFile);
    }

    /**
     * 将文件转换为字节数组， 使用MappedByteBuffer，可以在处理大文件时，提升性能
     *
     * @param file 文件
     * @return 二维码图片的字节数组
     */
    private static byte[] toByteArray(File file) {
        try (FileChannel fc = new RandomAccessFile(file, "r").getChannel();) {
            MappedByteBuffer byteBuffer = fc.map(MapMode.READ_ONLY, 0, fc.size()).load();
            byte[] result = new byte[(int) fc.size()];
            if (byteBuffer.remaining() > 0) {
                byteBuffer.get(result, 0, byteBuffer.remaining());
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将logo添加到二维码中间
     *
     * @param image     生成的二维码图片对象
     * @param imagePath 图片保存路径
     * @param logoFile  logo文件对象
     * @param format    图片格式
     */
    private static void overlapImage(BufferedImage image, String format, String imagePath, File logoFile)
            throws IOException {
        try {
            BufferedImage logo = ImageIO.read(logoFile);
            Graphics2D g = image.createGraphics();
            // 考虑到logo图片贴到二维码中，建议大小不要超过二维码的1/5;
            int width = image.getWidth() / 5;
            int height = image.getHeight() / 5;
            // logo起始位置，此目的是为logo居中显示
            int x = (image.getWidth() - width) / 2;
            int y = (image.getHeight() - height) / 2;
            // 绘制图
            g.drawImage(logo, x, y, width, height, null);

            // 给logo画边框
            // 构造一个具有指定线条宽度以及 cap 和 join 风格的默认值的实心 BasicStroke
            // logo默认边框宽度
            g.setStroke(new BasicStroke(2));
            // 边框颜色
            g.setColor(Color.RED);
            g.drawRect(x, y, width, height);

            g.dispose();
            // 写入logo图片到二维码
            ImageIO.write(image, format, new File(imagePath));
        } catch (Exception e) {
            throw new IOException("二维码添加logo时发生异常！", e);
        }
    }

    /**
     * 解析二维码
     *
     * @param file 二维码文件内容
     * @return 二维码的内容
     */
    public static String decodeQrcode(File file) throws IOException, NotFoundException {
        BufferedImage image = ImageIO.read(file);
        LuminanceSource source = new BufferedImageLuminanceSource(image);
        Binarizer binarizer = new HybridBinarizer(source);
        BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
        Map<DecodeHintType, Object> hints = Maps.newEnumMap(DecodeHintType.class);
        hints.put(DecodeHintType.CHARACTER_SET, Charsets.UTF_8.name());
        return new MultiFormatReader().decode(binaryBitmap, hints).getText();
    }
    /**
     * 判断对象中属性值是否全为空
     *
     * @param object
     * @return
     */
    public static boolean checkObjAllFieldsIsNull(Object object) {
        if (null == object) {
            return true;
        }

        try {
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);

                System.out.print(f.getName() + ":");
                System.out.println(f.get(object));

                if (f.get(object) != null ) {
                    return false;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public static void main(String[] args) throws NotFoundException, IOException {
//        List<Integer> list = null;
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);
//        list1.retainAll(list);
//        String seed = cn.hutool.core.date.DateUtil.format(new Date(), "yyyyMMddHHmmss");
//        String s = SecureUtil.md5(SecureUtil.md5("pjk2r7qu")+seed);
//        System.out.println(s);
//        System.out.println(seed);
//        int maxValue = Integer.MAX_VALUE;
//        System.out.println(maxValue);
////        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//        String a = "Fᴏʀᴇᴠᴇʀ¹⁸";
//        String b = "1";
//        String s = Optional.ofNullable(a).orElse("");
//        System.out.println(s);
//        createQrcodeMatrix("https://xaesttest.xiaoantimes.com/agent/organization1.html?type=h5Product&agentId=200490&channelId=0&productId=55&productType=0&shareId=53281&codeId=2994&offlineProduct=0", 200);
//        File file = new File("C:\\Users\\PC\\Desktop\\图片\\1.png");
//        byte[] qrcode = createQrcode("https://xaesttest.xiaoantimes.com/agent/organization1.html?type=H5&agentId=192299&channelId=353&productId=84&productType=0&shareId=37310&codeId=379&offlineProduct=0", 200, null);
//        String decode = URLDecoder.decode("29539", "UTF-8");
//        String encode = URLEncoder.encode("29539", "UTF-8");
//        String decodeQrcode = decodeQrcode(file);
//        System.out.println(decodeQrcode);
//        Long.valueOf("undefined");
//        Date current = new Date();
//        //获取当前时间：分钟
//        SimpleDateFormat format1 = new SimpleDateFormat("mm");
//        String curMinStr = format1.format(current);
//        System.out.println(curMinStr);
//        AtomicInteger atomicInteger = new AtomicInteger();
        //取出核额的产品
//        String str = "新微贷";
//        String newString = str.replaceAll("已通过", "").replace("新一贷快贷", "新一贷");
//        String[] split = newString.split("/");
//        Object[] objects = Arrays.stream(split).distinct().toArray();
//        StringBuilder result = new StringBuilder();
//        //遍历核额结果
//        for (Object s : objects) {
//            if (!"新一贷".equals(s)) {
//                //多个核额结果拼接
//                result.append(s).append("/");
//            }
//        }
//        System.out.println(result.toString());
//        String replace = "新一贷/新一贷快贷已通过".replaceAll("已通过", "").replace("新一贷快贷", "新一贷");
//        String[] split = replace.split("/");
//        Object[] objects = Arrays.stream(split).distinct().toArray();
//        String s2 = "/user/pointDataService/add";
//        String s = "/user/SjptStatisticService/getChannelIdAndNameForBD,/user/yqh/cust/,/user/fengcengtestservice/,/user/pazdd/cust/,/user/yjyd/cust/,/user/yxcdd/cust/,/user/loanRecordRollService/,/user/loanLinesEvaluateService/,/user/xazrJjrProCityCommissionRatioService/getCommissionRatioBySpecCh,/user/registerUserAdvertis/,/user/leaderBoard/,/user/daCheng/,/user/userWyPointsService/callBack,/user/face/,/user/pay/,/user/xazrOrderInfo/,/user/wechatPayNotify/,/user/xazrJjrProductManagerumService/,/user/paxy/cust/,/user/paxy/cust/test/,/user/xazrJjrAgentActivityGzhService/,/user/xazrProductCommentXcxService/,/user/pacd/cust/,/user/xaOldUserService/,/user/xazrCustomerLoanBasicInformationService/,/user/agentLastRequestTimeService/,/user/xazrJjrAgentDevService/,/product/jjr/xazrProductDetailService/,/user/xazrJjrAgentDevService/,/product/moduleStatusService/,/user/wxMessage/autoReply,/user/gzh/,/user/xcx/pointDataService/add,/user/xcx/timeDataService/add,/user/xazrJjrNoCommunicateCustomerClientService/,/user/ProductStatusCodeMapService/,/product/xcx/xazrProductService/,/user/carEvaluationService/,/user/allCarBrandsService/,/user/carLottery/,/user/timeDataService/add,/user/pointDataService/add,/user/xazrJjrAgentStatisticsService,/user/xazrJjrAgentService,/user/xazrAgentService,/user/wxPaService/,/user/loanCustomerInformationService/,/user/matchLoanSchemeService/,/user/miniProgram/,/sysmgt/bannerService/,/user/news/list/gategory,/user/news/,/auth/jwt/getClientToken,/auth/jwt/getClientTokenFromShareLink,/auth/jwt/token,/auth/jwt/authToken,/user/userService/getLoginSmsCode,/user/userService/setPassword,/user/userService/getSmsCode,/picture/downFile,/user/userService/verifySmsCode,/user/CustomerCreditCheckService/faceVerifyResultCallback,/user/customerLoanMgtService/loan/statusNotify,/user/wechatService/getSignature,/user/wechatService/getFacialOCR,/product/app/basicInfo/page,/product/app/basicInfo/find,/product/jjr/xazrProductService/,/user/xazrJjrBankCardBindingService/,/user/xazrPointsMonthRankService/currentMonthPointsBoard,/user/xazrPointsDayRankService/agentCreditDayList,/user/xazrPointsMonthRankHistoryService/lastMonthPointsBoard,/user/xazrCustomerLoanBasicInformationService/getMyLoanProgress,/user/xazrAgentImageLibraryService/uploadImage,/user/xazrAgentImageLibraryService/listAllImage,/user/xazrAgentImageLibraryService/deleteImage,/user/gzhOperatingService/checkSignature,/user/gzhOperatingService/gzhRedirect,/user/gzhOperatingService/relateOpenIdAndAgent,/user/gzhOperatingService,/user/SjptStatisticService/sjptSmallStatistic,/user/testService,/product/orgProduct,/user/loanClue,/user/ClueManager/,/product/PostManager/,/sysmgt/bannerMgtService/,/user/ProductStatistic/,/user/dcfwptcustBasicInfoService/verifyGzhWxCode,/user/daChengPublic/,/user/xazrJjrAgentDevService/clickActivation,/user/xazrJjrAgentStatisticsService/getOpenIdByWxCode,/user/xazrStoreProChannelRel/getCityByProductId,/user/storeInfo/acceptanceStores,/user/popupInfoService/,/user/platformQrcodeService/,/user/popupVisitRecordInfoService/,/user/xazrAwakenPolicyService/,/user/sharingEconomySettlementService/,/user/xazrPushTriggerService/,/user/xazrPushTriggerStatusService/,/user/xazrQrcodeLogService/,/user/activitycenter,/user/GrowthFundPointsReviewDetails/,/user/xazrJjrPointsAddGrade,/user/xazrJjrSubscriptionManagementService,/picture/oss/,/user/acsconversation/,/product/rdb/rdbCustomerWechatApp/,/product/companyIntroduce/getCompanyIntroduceById,/product/companyIntroduce/getRecommendedProducts,/user/xazrProductParamConfigurationService/,/user/OrderRecord/,/user/acsConsultingCustomerEvaluation/,/user/xazrCustomerService/getdcfwptCustomer,/user/rdb/pointDataService/getResult,/user/oneToOneConsulting/saveConsultingEvaluationOrderInfo,/user/oneToOneConsulting/ConsultingEvaluationWeChatUnifiedOrder,/user/oneToOneConsulting/paySuccessByConsult.do,/user/acs/,/product/rdb/rdbCustomerWechatApp/getProductInformation,/user/acsConsultingKycRecord/getAcsConsultingKycRecord,/user/acsConsultingKycRecord/saveAcsConsultingKycRecord,/user/consultingLoanPlan,/product/xazrJjrProduct/selectByproductId,/auth/jwt/storeToken,/product/AcsProductAppProcess/selectDocuType,/product/app/schedule/xazrJjrProductDetailProductId,/user/XazrProdManUmService/getManagerUm/,/user/paxwd/cust/,/user/creditreportUploadService/,/product/AcsProductAppProcess/selectDocuTypeById,/product/acs/,/user/orderOffPointMonitor/,/product/orderOffPointMonitor/,user/xazrCustomerLoanEvaluateService/,/t/,/user/xazrCustomerService/isSubscribeRdb,/user/oneToOneConsulting/,/product/upload/,/user/xazrOrderOffPointService/,/product/docuCodeTbl/,/product/docuTypeTbl/,/product/appNodeTbl/,/user/xazrJjrAgentService/canTK,/user/acsBrokerageAgreementController/,user/xazrPazddCountingResDateService/,/user/XazrJjrCustomerLabelManagementService/,/user/callRecords/saveCallRecords,/user/jjrTKRange/openTkAuth,/user/jjrTKRange/inTkJjrs,/product/productMain/,/user/acsStore/,user/xazrRepayTipsRecord/,/user/loanCalculateResultService,/user/userSourceManagement,user/xazrRepayTipsRecord/,/user/multiProductEvaluation/,/product/xazrProduct/getProductForApply,/user/xazrJjrPointsWithdrawYunlai,/user/xazrJjrPointsWithdrawBear,/user/xazrDqevaCustEvaResultRecord,/user/household,/user/insurance,/user/issue,/user/reviewRecords,/user/xazrDqevaAgentRecommendProductRecord,/user/jjrBasicInformation,/user/Accomplishment,/user/accomplishment,/user/xazrAupgradeAgentShareRecordService,/user/xazrAupgradeAgentShareRecordService,/user/xazrAupgradeUserAgentRelationService,/user/csQrcodeConfiguration,/user/articleInformation,/user/agentInviteRecord,/user/frequentService,/user/taskCompleted,/user/circleMaterialService,/user/XazrAupgradeAcceptanceModeRecordService,/user/weComOperation,/user/inviteeTrackingRecord,/user/inviterRegMaterialShareRecord,/user/loanHistoryRecord,/user/levelCommission,/user/apiHomePageLabel,/user/xazrAupgradeExperiencePointRewardRecordService,/user/apiHomePageLabel,/user/apiScanAds,/user/xazrJjrNewSuperPartnerRegisterRecordService,/user/xazrJjrAgentAutoLoginRecordService/,/user/getHomeTopReport";
//        String[] split = s.split(",");
//        for (String s1 : split) {
//            if (s2.startsWith(s1) || s2.contains(s1)){
//                System.out.println("1111");
//                break;
//            }
//        }
//        HashMap<String, String> stringStringHashMap = new HashMap<>();
//        stringStringHashMap.put("1", "1");
//        stringStringHashMap.remove("2");
//        BigDecimal multiply = new BigDecimal(0).multiply(new BigDecimal("0.001"));
//        System.out.println(multiply);
    }

}

