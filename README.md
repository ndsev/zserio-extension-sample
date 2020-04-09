# Zserio Extension Sample

Sample implementation of Zserio extension.

This extension prints all AST (Abstract Syntax Tree) nodes to the terminal. The extension can be invoked by
command line option `-sample`.

Zserio extension is a Java [extension](link) which must implement `zserio.tools.Extension` interface. This
interface provides to the Zserio core:

- **Name** of the extension. Zserio core uses this name for reporting.
- **Version** of the extension. Zserio core will accept the extension only and only if this extension
  version is the same as the Zserio core version.
- **Command Line Options** accepted by the extension. These command line options will be registered by the
  Zserio core.
- **Enabled Flag** of the extension. Zserio core will run the extension only and only if this enabled flag is
  `true`. This allows the extension to check the command line options.
- **Entry point** of the extension. Zserio core will call this entry point to generate all outputs from the
  extension. 

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
