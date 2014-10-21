package tea.looca;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class JavaStackTest {

	public static void main(String[] args) {
		{

			Stack<String> stack = new Stack<String>();
			for (int i = 0; i<10; i++) {
				System.out.println(stack.push(""+i));
			}
			while (!stack.empty()) {
				System.out.println(stack.pop());
			}
			int stackDepth = 10;
			int stopPoint =(int )(Math.random()*(stackDepth-1)) + 1;
			for (int i = 0; i<1000; i++) {
				//System.out.println((int )(Math.random()*(stackDepth-1)) + 1);
			}
			Stack<String> opStack = new Stack<String>();
			for (int i = 0; i<stackDepth; i++) {
				opStack.push( (int )(Math.random()*2) == 1? "lock":"unlock");
			}
			int c= 0;
			while (!opStack.empty()) {
				System.out.println(""+ (++c) +"\t"+opStack.pop());
			}
		
			for (int i = 0; i<stackDepth; i++) {
				opStack.push( (int )(Math.random()*2) == 1? "lock":"unlock");
			}
			//opStack.elementAt(index)
			int misMatchCount = 0;
			int totalCount = 0;
			for (int i =0; i <=1000; i++) {
				int p =1;
				Stack<String> localStack = new Stack<String>();
				localStack.addAll(opStack);
				//localStack.addAll(opStack);
				while (!localStack.empty() && p++!=stopPoint) {
					//System.out.println(""+ (++c) +"\t"+localStack.pop());
					String str = localStack.pop();
					System.out.println(str);
					if (!str.toString().equals(opStack.elementAt(opStack.size()-(p-1)))) {
						misMatchCount++;
					}
					totalCount++;
				}
			}
			System.out.println ("misMatchCount = "+misMatchCount);
			System.out.println ("totalCount = "+totalCount);
		}
		{
			int stackDepth = 10;
			int stopPoint =(int )(Math.random()*(stackDepth-1)) + 1;
			Stack<String> opStack = new Stack<String>();
			for (int i = 0; i<stackDepth; i++) {
				opStack.push( (int )(Math.random()*2) == 1? "lock":"unlock");
			}
			Stack<String> localStack = new Stack<String>();
			localStack.addAll(opStack);
			
			// clone then cast works, but compiling warning.
			int p = 1;
			while (!localStack.empty() && p++!=stopPoint) {
				String str = localStack.pop();
				if (str.toString().equals("lock")) {
					// TODO Lock batch1
				} else {
					// TODO unlock batch1
				}
			}

			
			p = 1;
			while ( p++!=stopPoint) {
				// TODO undo
			}
			String lastOp = opStack.elementAt(opStack.size()-(p-1));
			if (lastOp.toString().equals("lock")) {
				// TODO Assert locked!=true
			} else {
				// TODO Assert locked!=false
			}
			
			// TODO Redo 
			if (lastOp.toString().equals("lock")) {
				// TODO Assert locked=true
			} else {
				// TODO Assert locked=false
			}
			
		}
		{
			System.out.println("============");
			int stackDepth = 10;
			int stopPoint =(int )(Math.random()*(stackDepth-1)) + 1;
			Stack<String> opStack = new Stack<String>();
			for (int i = 0; i<stackDepth; i++) {
				if (((int) (Math.random() * 2)) == 1) {
					opStack.push("lock".toString());
				} else {
					opStack.push("unlock".toString());
				}
				// GROOVY UNFRIENDLY (not unfriendly, just not working) : opStack.push( (int )(Math.random()*2) == 1? "lock":"unlock");
			}
			Queue<String> opQueue = new LinkedList<String>();
			//opQueue.addAll(opStack); // WRONG
			Stack<String> localStack = new Stack<String>();
			localStack.addAll(opStack);
			while (!localStack.isEmpty()) {
				opQueue.add(localStack.pop());
			}
			// Assure the queue is the reverse of the stack
//			while (!opQueue.isEmpty() && !opStack.isEmpty() ) {
//				System.out.println(opQueue.poll().toString().equals(opStack.pop().toString()));
//			}
//			System.out.println("opQueue.isEmpty()="+opQueue.isEmpty()+"\topStack.isEmpty()"+opStack.isEmpty());
			while (!opQueue.isEmpty()) {
				String str = opQueue.poll();
				if (str.toString().equals("lock")) {
					// TODO Lock batch1
				} else {
					// TODO unlock batch1
				}
			}
			int p = 1;
			String lastOp = null;
			while ( p++!=stopPoint) {
				// TODO undo
				// TODO lastOp = pop stack
				lastOp = opStack.pop();
			}
			
			if (lastOp.toString().equals("lock")) {
				// TODO Assert locked!=true
			} else {
				// TODO Assert locked!=false
			}
			
			// TODO Redo 
			if (lastOp.toString().equals("lock")) {
				// TODO Assert locked=true
			} else {
				// TODO Assert locked=false
			}

			// TODO Redo, two or more redos equal one redo
			if (lastOp.toString().equals("lock")) {
				// TODO Assert locked=true
			} else {
				// TODO Assert locked=false
			}
		}
		


        //TODO there is a logic error, OPs should be the reverse of the stack
        /*
        p = 1;
        while (!localStack.empty() && p++!=stopPoint) {
            String str = localStack.pop();
            println "p="+p +" "+str
            if (str.toString().equals("lock")) {
                // TODO Lock batch1
                lockUnlockVerifyBatch (batch1,g('common'),contentIdInTest,g('widget'),projectIdInTest,chapterIdInTest,[locked:"true"])
            } else {
                // TODO unlock batch1
                lockUnlockVerifyBatch (batch1,g('common'),contentIdInTest,g('widget'),projectIdInTest,chapterIdInTest,[locked:"false"])
            }
        }
        */

        /* A Logical error in transactions' stack.
        p = 1;
        while ( p++!=stopPoint) {
            // TODO undo
            resp = g('UndoRedo').undo(projectIdInTest)
        }
        String lastOp = opStack.elementAt(opStack.size()-(p-1));

        resp = g('UndoRedo').redo(projectIdInTest)
        assertEquals((resp =  g('content').get(projectIdInTest, contentIdInTest)).status, 200, "fail get content")
        if (lastOp.toString().equals("lock")) {
            // TODO Assert locked!=true
            verifyAttributes(batch1, ["properties","locked"],resp,"false")
        } else {
            // TODO Assert locked!=false
            verifyAttributes(batch1, ["properties","locked"],resp,"true")
        }

        // TODO Redo
        resp = g('UndoRedo').redo(projectIdInTest)
        assertEquals((resp =  g('content').get(projectIdInTest, contentIdInTest)).status, 200, "fail get content")
        if (lastOp.toString().equals("lock")) {
            // TODO Assert locked=true
            verifyAttributes(batch1, ["properties","locked"],resp,"true")
        } else {
            // TODO Assert locked=false
            verifyAttributes(batch1, ["properties","locked"],resp,"false")
        }

        // TODO Redo, two successive redos or more equal one redo.
        resp = g('UndoRedo').redo(projectIdInTest)
        if (lastOp.toString().equals("lock")) {
            // TODO Assert locked=true
            verifyAttributes(batch1, ["properties","locked"],resp,"true")
        } else {
            // TODO Assert locked=false
            verifyAttributes(batch1, ["properties","locked"],resp,"false")
        }
        */
	

	}


}
