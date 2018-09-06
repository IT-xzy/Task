package task06.util;


/**
 *
 */
public class Page {

	private int start = 0;
	private int count = 5;
	private int last = 0;

	// id 缓存组的大小
	// private int idGroupSize = 5;
	// id 缓存组的倍数
	// private int idGroupBasis = start/idGroupSize;
	// id 缓存组开始点
	// private int idGroupsStart = idGroupBasis * idGroupSize;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public void caculateLast(int total) {
		// 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
		if (0 == total % count) {
			last = total - count;
		} else{
			// 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
			last = total - total % count;
		}
	}

	public void firstJudge ( int total){
		if ( start < 0){
			start = 0;
		}
		if (start > total){
			if (0 == total % count) {
				last = total - count;
			} else{
				// 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
				last = total - total % count;
			}
		}
	}





	@Override
	public String toString() {
		return "Page{" +
				"start=" + start +
				", count=" + count +
				", last=" + last +
				'}';
	}



}
