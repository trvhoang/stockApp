package core;

public class STATICSTRING {
    public static final String VNDIRECT_BANG_CAN_DOI_KE_TOAN = "VNDIRECT_BCDKT";
    public static final String VNDIRECT_BAO_CAO_KQKD = "VNDIRECT_BCKQKD";
    public static final String VNDIRECT_BAO_CAO_LUU_CHUYEN_TIEN_TE = "VNDIRECT_BCLCTT";
    public static final String FINANCE = "VNDIRECT";

    public static final String DATA_CURRENT_EPS = "$[1].['Chỉ số tài chính'][?(@.Name == 'EPS của 4 quý gần nhất')].Value4";
    public static final String DATA_OLD_EPS = "$[1].['Chỉ số tài chính'][?(@.Name == 'EPS của 4 quý gần nhất')].Value1";

    public static final String DATA_CURRENT_EQUITY = "$.['Vốn góp'].2018";
    public static final String DATA_OLD_EQUITY = "$.['Vốn góp'].2015";

}
