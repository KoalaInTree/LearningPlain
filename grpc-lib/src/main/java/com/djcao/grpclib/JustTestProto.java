// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: justtest.proto

package com.djcao.grpclib;

public final class JustTestProto {
  private JustTestProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_onlytest_TestRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_onlytest_TestRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_onlytest_TestResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_onlytest_TestResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\016justtest.proto\022\010onlytest\"\033\n\013TestReques" +
      "t\022\014\n\004name\030\001 \001(\t\"\037\n\014TestResponse\022\017\n\007messa" +
      "ge\030\001 \001(\t2K\n\007Greeter\022@\n\rTestSomeThing\022\025.o" +
      "nlytest.TestRequest\032\026.onlytest.TestRespo" +
      "nse\"\000B)\n\021com.djcao.grpclibB\rJustTestProt" +
      "oP\001\242\002\002WYb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_onlytest_TestRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_onlytest_TestRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_onlytest_TestRequest_descriptor,
        new String[] { "Name", });
    internal_static_onlytest_TestResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_onlytest_TestResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_onlytest_TestResponse_descriptor,
        new String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}