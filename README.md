# Zserio Extension Sample

Sample implementation of Zserio extension.

This extension prints all AST (Abstract Syntax Tree) nodes to the terminal. The extension can be invoked by
command line option `-sample`.

**Example**

Using the schema

```
package simple_structure;

struct SimpleStructure
{
    int32  numberA;
    uint8  numberB;
    string name;
}
```

gives Zserio compiler together with this Zserio extension sample the following output:

```
Parsing simple_structure.zs
Calling Sample extension check
Calling Sample extension
  package simple_structure
    structure SimpleStructure
      int32 numberA
      uint8 numberB
      string name
Done
```

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

```bash
java -cp build/download/zserio_libs/zserio_core.jar:distr/zserio_sample.jar \
    zserio.tools.ZserioTool simple_structure.zs -sample
```

## Bundled Zserio

There is a sample implementation of bundled Zserio which will contain all extensions found in the original
bundled Zserio together with the extension sample.

### Build

```bash
ant zserio_bundle.install
```

### Run

```bash
java -jar distr/zserio.jar simple_structure.zs -sample
```
