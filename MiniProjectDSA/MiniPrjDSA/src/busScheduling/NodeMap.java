package busScheduling;

public class NodeMap {
	int id;
	int neighbor;
	int distance;
	NodeMap next;
	public NodeMap(int id, int neighbor, int distance) {
		this.id = id;
		this.neighbor = neighbor;
		this.distance = distance;
		this.next = null;
	}
	private static NodeMap first;
	private static NodeMap temp;
	private static NodeMap new_temp;
	
	public NodeMap getNew_temp() {
		return new_temp;
	}
	public static void setNew_temp(int id, int neighbor, int distance) {
		NodeMap.new_temp = new NodeMap(id, neighbor, distance);
	}
	public static void setNew_temp(NodeMap new_temp) {
		NodeMap.new_temp = new_temp;
	}
	public NodeMap() {
		super();
	}
	public static NodeMap getFirst() {
		return first;
	}
	public static void setFirst(NodeMap first) {
		NodeMap.first = first;
	}
	public static NodeMap getTemp() {
		return temp;
	}
	public static void setTemp(NodeMap temp) {
		NodeMap.temp = temp;
	}
	public static void setTemp_next(NodeMap temp) {
		NodeMap.temp.next = temp;
	}
	private int findDistance(NodeMap temp, int from, int to) {
		if(temp == null) return 0;
		if(temp.id == from && temp.neighbor == to) {
			return temp.distance;
		}
		return findDistance(temp.next, from, to);
	}
	public int findDistance(int from, int to) {
		return findDistance(first, from, to);
	}
	//private static void show(NodeMap temp) {
	//	if(temp == null) return;
	//	System.out.println(/*temp + " " +*/temp.id + " " + temp.neighbor + " " + temp.distance/* + " " + temp.next*/);
	//	show(temp.next);
	//	return;
	//}
	//public static void show() {
	//	show(first);
	//}
	
}
