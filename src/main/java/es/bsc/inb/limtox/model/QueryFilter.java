package es.bsc.inb.limtox.model;

public class QueryFilter {

	private Integer pageSize;
	
	private Integer pageNumer;
	
	private String endPoint;
	
	private String keyWordToSearch;
	
	private String keyWordSearchEntityType;

	
	
	public QueryFilter(String endPoint, String keyWordToSearch, String keyWordSearchEntityType, Integer pageSize, Integer pageNumer) {
		this.pageSize = pageSize;
		this.pageNumer = pageNumer;
		this.endPoint = endPoint;
		this.keyWordToSearch = keyWordToSearch;
		this.keyWordSearchEntityType = keyWordSearchEntityType;
	}

	

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNumer() {
		return pageNumer;
	}

	public void setPageNumer(Integer pageNumer) {
		this.pageNumer = pageNumer;
	}

	

	public String getKeyWordToSearch() {
		return keyWordToSearch;
	}

	public void setKeyWordToSearch(String keyWordToSearch) {
		this.keyWordToSearch = keyWordToSearch;
	}

	public String getKeyWordSearchEntityType() {
		return keyWordSearchEntityType;
	}

	public void setKeyWordSearchEntityType(String keyWordSearchEntityType) {
		this.keyWordSearchEntityType = keyWordSearchEntityType;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	
	
	
}
