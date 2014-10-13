package tea.looca;

public class ShadowVSOverride {
	static public class Parent {
		static final int sid = 1;
		final int id =2;
		static final int fid = 5;
		public void showBadge () {
			System.out.println("sid="+sid +"\t"+"id="+id+"\t"+"fid="+fid);
		}
	}
	static public class Child extends Parent {
		static final int sid = 3;
		final int id =4;
		final int fid = 6;
		@Override
		public void showBadge () {
			System.out.println("sid="+sid +"\t"+"id="+id+"\t"+"fid="+fid);
		}
	}

	public static void main(String[] args) {
		 Child c1 = new Child();
		 Parent p2 = new Child();
		 Parent p1 = new Parent();
		 c1.showBadge();
		 p1.showBadge();
		 p2.showBadge();

	}

}
//sid=3	id=4	fid=6
//sid=1	id=2	fid=5
//sid=3	id=4	fid=6
