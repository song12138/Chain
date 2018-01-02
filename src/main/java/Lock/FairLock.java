package Lock;
/**
 * 准确地说如何从之前的Lock类做到公平锁的设计是一个渐进设计的过程，每一步都是在解决上一步的问题而前进的：Nested Monitor Lockout, Slipped Conditions和
 * Missed Signals。这些本身的讨论虽已超出本文的范围，但其中每一步的内容都将会专题进行讨论。
 * 重要的是，每一个调用lock()的线程都会进入一个队列，当解锁后，只有队列里的第一个线程被允许锁住Farlock实例，所有其它的线程都将处于等待状态，直到他们处于队列头部
 */

import java.util.List;

/**
 *
 *
 * Created by paul on 2017/11/22.
 */
public class FairLock {

    private boolean isLocked = false;

    private Thread lockingThread = null;


//    private List<>

}
