/*
 * Copyright DataStax, Inc.
 *
 * This software can be used solely with DataStax Enterprise. Please consult the license at
 * http://www.datastax.com/terms/datastax-dse-driver-license-terms
 */
package com.datastax.dse.driver.internal.core.graph.binary.buffer;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import org.apache.tinkerpop.gremlin.structure.io.Buffer;

/**
 * Internal impl of Tinkerpop Buffers. We implement an internal type here to allow for this class to
 * use shaded Netty types (without bringing all of Tinkerpop into the shaded JAR). The impl is based
 * on the initial impl of {@link NettyBuffer} but we don't guarantee that this class will mirror
 * changes to that class over time.
 */
final class DseNettyBuffer implements Buffer {
  private final ByteBuf buffer;

  /**
   * Creates a new instance.
   *
   * @param buffer The buffer to wrap.
   */
  DseNettyBuffer(ByteBuf buffer) {
    if (buffer == null) {
      throw new IllegalArgumentException("buffer can't be null");
    }

    this.buffer = buffer;
  }

  @Override
  public int readableBytes() {
    return this.buffer.readableBytes();
  }

  @Override
  public int readerIndex() {
    return this.buffer.readerIndex();
  }

  @Override
  public Buffer readerIndex(final int readerIndex) {
    this.buffer.readerIndex(readerIndex);
    return this;
  }

  @Override
  public int writerIndex() {
    return this.buffer.writerIndex();
  }

  @Override
  public Buffer writerIndex(final int writerIndex) {
    this.buffer.writerIndex(writerIndex);
    return this;
  }

  @Override
  public Buffer markWriterIndex() {
    this.buffer.markWriterIndex();
    return this;
  }

  @Override
  public Buffer resetWriterIndex() {
    this.buffer.resetWriterIndex();
    return this;
  }

  @Override
  public int capacity() {
    return this.buffer.capacity();
  }

  @Override
  public boolean isDirect() {
    return this.buffer.isDirect();
  }

  @Override
  public boolean readBoolean() {
    return this.buffer.readBoolean();
  }

  @Override
  public byte readByte() {
    return this.buffer.readByte();
  }

  @Override
  public short readShort() {
    return this.buffer.readShort();
  }

  @Override
  public int readInt() {
    return this.buffer.readInt();
  }

  @Override
  public long readLong() {
    return this.buffer.readLong();
  }

  @Override
  public float readFloat() {
    return this.buffer.readFloat();
  }

  @Override
  public double readDouble() {
    return this.buffer.readDouble();
  }

  @Override
  public Buffer readBytes(final byte[] destination) {
    this.buffer.readBytes(destination);
    return this;
  }

  @Override
  public Buffer readBytes(final byte[] destination, final int dstIndex, final int length) {
    this.buffer.readBytes(destination, dstIndex, length);
    return this;
  }

  @Override
  public Buffer readBytes(final ByteBuffer dst) {
    this.buffer.readBytes(dst);
    return this;
  }

  @Override
  public Buffer readBytes(final OutputStream out, final int length) throws IOException {
    this.buffer.readBytes(out, length);
    return this;
  }

  @Override
  public Buffer writeBoolean(final boolean value) {
    this.buffer.writeBoolean(value);
    return this;
  }

  @Override
  public Buffer writeByte(final int value) {
    this.buffer.writeByte(value);
    return this;
  }

  @Override
  public Buffer writeShort(final int value) {
    this.buffer.writeShort(value);
    return this;
  }

  @Override
  public Buffer writeInt(final int value) {
    this.buffer.writeInt(value);
    return this;
  }

  @Override
  public Buffer writeLong(final long value) {
    this.buffer.writeLong(value);
    return this;
  }

  @Override
  public Buffer writeFloat(final float value) {
    this.buffer.writeFloat(value);
    return this;
  }

  @Override
  public Buffer writeDouble(final double value) {
    this.buffer.writeDouble(value);
    return this;
  }

  @Override
  public Buffer writeBytes(final byte[] src) {
    this.buffer.writeBytes(src);
    return this;
  }

  @Override
  public Buffer writeBytes(final ByteBuffer src) {
    this.buffer.writeBytes(src);
    return this;
  }

  @Override
  public Buffer writeBytes(byte[] src, final int srcIndex, final int length) {
    this.buffer.writeBytes(src, srcIndex, length);
    return this;
  }

  @Override
  public boolean release() {
    return this.buffer.release();
  }

  @Override
  public Buffer retain() {
    this.buffer.retain();
    return this;
  }

  @Override
  public int referenceCount() {
    return this.buffer.refCnt();
  }

  @Override
  public ByteBuffer[] nioBuffers() {
    return this.buffer.nioBuffers();
  }

  @Override
  public ByteBuffer nioBuffer() {
    return this.buffer.nioBuffer();
  }

  @Override
  public ByteBuffer nioBuffer(final int index, final int length) {
    return this.buffer.nioBuffer(index, length);
  }

  @Override
  public ByteBuffer[] nioBuffers(final int index, final int length) {
    return this.buffer.nioBuffers(index, length);
  }

  @Override
  public int nioBufferCount() {
    return this.buffer.nioBufferCount();
  }

  @Override
  public Buffer getBytes(final int index, final byte[] dst) {
    this.buffer.getBytes(index, dst);
    return this;
  }

  /** Returns the underlying buffer. */
  public ByteBuf getUnderlyingBuffer() {
    return this.buffer;
  }
}
