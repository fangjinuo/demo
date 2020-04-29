package com.jn.demo;

public class FileTransfer {
    /**
     * 1、io.netty.channel.FileRegion 用于 zero-copy 方式来进行文件传输
     * 2、ChunkedFile 用于 非 zero-copy 方式的文件传输
     * 3、ChunkedInput 用于基于InputStream的方式进行流式传输，ChunkedFile是ChunkedInput的一种情况
     * 4、使用ChunkedInput传输时，最好是结合ChunkedWriteHandler来进行操作
     * 5、DefaultChannelProgressivePromise 用于表示传输的进度
     */
}
