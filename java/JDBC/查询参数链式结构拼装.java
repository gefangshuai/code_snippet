public class ArrayParams {
	private static Logger logger = Logger.getLogger(MapParams.class);
	private List<Object> params;
	private String pattern = "yyyy-MM-dd";

	private ArrayParams() {
	}

	public static ArrayParams begin() {
		ArrayParams arrayParams = new ArrayParams();
		arrayParams.setParams(new ArrayList<Object>());
		return arrayParams;
	}

	/**
	 * 指定日期格式
	 * 
	 */
	public static ArrayParams begin(String pattern) {
		ArrayParams arrayParams = begin();
		arrayParams.setPattern(pattern);
		return arrayParams;
	}

	public ArrayParams add(Object value) {
//		if (value == null) {
//			logger.debug("param value cannot be null!");
//			throw new RuntimeException("param value cannot be null!");
//		}
		Object strVal = null;
		if (value instanceof Date) { // 处理日期类型
			SimpleDateFormat jdf = new SimpleDateFormat(getPattern());
			strVal = jdf.format((Date) value);
		} else {
			strVal = value;
		}

		params.add(strVal);
		return this;
	}

	/**
	 * 返回查询参数集
	 * @return
	 */
	public Object[] end() {
		return this.params.toArray();
	}

	public List<Object> getParams() {
		return params;
	}

	public String getPattern() {
		return pattern;
	}

	public void setParams(List<Object> params) {
		this.params = params;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}
