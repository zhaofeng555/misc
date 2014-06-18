package hjg.enums;

/**
 * @author hjg
 * @version 创建时间：2010-11-6下午01:33:33
 * 
 **/
public enum Gender {
	MAN {
		public String getTitle() {
			return "男";
		}
	},
	WOMAN {
		public String getTitle() {
			return "女";
		}
	},
	BOTH {
		public String getTitle() {
			return "男女均可";
		}
	};
	public abstract String getTitle();

	public String getValue() {
		return this.name();
	}
}