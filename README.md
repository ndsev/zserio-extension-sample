# Zserio Extension Sample

Sample implementation of Zserio extension.

This extension prints all AST (Abstract Syntax Tree) nodes to the terminal. The extension can be invoked by
command line option `-sample`.

Zserio extension is a Java [extension](https://docs.oracle.com/javase/tutorial/ext/index.html) which must
implement [`zserio.tools.Extension`](https://github.com/ndsev/zserio/blob/v2.0.0-pre3/compiler/core/src/zserio/tools/Extension.java) interface.

## Prerequisites

1. Java SDK
2. [Apache Ant](https://ant.apache.org/)
3. Zserio core (`zserio_core.jar`) together with dependent libraries.

> Zserio core with dependent libraries will be automatically downloaded from
[GitHub](https://github.com/ndsev/zserio/releases) according to the extension version located in the module
`SampleExtension.java`.

## Build

```bash
ant install
```

## Run

Using new bundle jar:

```bash
java -jar distr/zserio.jar simple_structure.zs -sample
```

Alternatively using Zserio core only:

```bash
java -cp build/download/zserio_libs/zserio_core.jar:distr/zserio_sample.jar zserio.tools.ZserioTool simple_structure.zs -sample
```
