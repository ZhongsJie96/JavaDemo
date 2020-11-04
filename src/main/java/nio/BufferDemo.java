package nio;

import java.nio.CharBuffer;

public class BufferDemo {
    public static void main(String[] args) {
        CharBuffer buff = CharBuffer.allocate(8);
        System.out.println(buff.capacity());
        System.out.println(buff.limit());
        System.out.println(buff.position());
        buff.put("a");
        buff.put("b");
        buff.put("c");
        System.out.println(buff.position());
        // 将limit移到原来position的位置
        buff.flip();
        System.out.println(buff.limit());
        System.out.println(buff.position());
        System.out.println(buff.get());
        System.out.println(buff.position());
        // 执行clear方法之后只是将position设为0，将limit设为与capacity相等
        buff.clear();
        System.out.println(buff.limit());
        System.out.println(buff.position());
        System.out.println(buff.get(2));
        System.out.println(buff.position());
    }
}
