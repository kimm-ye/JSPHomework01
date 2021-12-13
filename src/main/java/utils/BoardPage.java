package utils;

public class BoardPage {
	
	public static String pagingStr(int totalCount, int pageSize, int blockPage, int pageNum, String reqUrl) {
		
		String pagingStr ="";
		
		int totalPages = (int)(Math.ceil(((double) totalCount / pageSize))); //전체 페이지수
		
		int pageTemp = (((pageNum - 1) / blockPage) * blockPage) + 1;
		
		if(pageTemp != 1) {
			pagingStr += "<li class='page-item'><a class='page-link' href='" + reqUrl + "?pageNum=1'><i class='bi bi-skip-backward-fill'></i></a>&nbsp;</li>";
			//pagingStr += "<a href='" + reqUrl + "?pageNum=1'>[처음으로]</a>";
			//pagingStr += "&nbsp;";
			pagingStr += "<li class='page-item'><a class='page-link'href='" + reqUrl + "?pageNum=" + (pageTemp - 1) + "'><i class='bi bi-skip-backward-fill'></i></a></li>";
			//pagingStr += "<a href='" + reqUrl + "?pageNum=" + (pageTemp - 1) + "'>[이전 페이지]</a>";
		}
		
		int blockCount = 1;
		while(blockCount <= blockPage && pageTemp <= totalPages) {
			if(pageTemp == pageNum) {
				pagingStr += "<li class='page-item active'><a class='page-link'>&nbsp;"+ pageTemp + "&nbsp;</a></li>";
				//pagingStr += "&nbsp;" + pageTemp + "&nbsp;";
			}
			else {
				pagingStr += "<li class='page-item'><a class='page-link' href='" + reqUrl + "?pageNum=" + pageTemp + "'>&nbsp;" + pageTemp + "&nbsp;</a></li>";
				//pagingStr += "&nbsp;<a href='" + reqUrl + "?pageNum=" + pageTemp + "'>" + pageTemp + "</a>&nbsp;";
			}
			pageTemp++;
			blockCount++;
		}
		
		if(pageTemp <= totalPages) {
			pagingStr += "<li class='page-item'><a class='page-link' href='" + reqUrl +"?pageNum=" + pageTemp + "'><i class='bi bi-skip-end-fill'></i></a> &nbsp;</li>";
			//pagingStr += "<a href='" + reqUrl +"?pageNum=" + pageTemp + "'>[다음 페이지]</a>";
			//pagingStr += "&nbsp;";
			pagingStr += "<li class='page-item'><a class='page-link' href='" + reqUrl + "?pageNum=" + totalPages + "'><i class='bi bi-skip-forward-fill'></i></a></li>";
			//pagingStr += "<a href='" + reqUrl + "?pageNum=" + totalPages + "'>[마지막으로]</a>";
		}
		
		return pagingStr;
	}
}
