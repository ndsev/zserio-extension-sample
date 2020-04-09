package zserio.emit.sample;

import zserio.ast.BitmaskType;
import zserio.ast.ChoiceType;
import zserio.ast.CompoundType;
import zserio.ast.Constant;
import zserio.ast.EnumType;
import zserio.ast.Field;
import zserio.ast.Import;
import zserio.ast.Package;
import zserio.ast.PubsubType;
import zserio.ast.ServiceType;
import zserio.ast.SqlDatabaseType;
import zserio.ast.SqlTableType;
import zserio.ast.StructureType;
import zserio.ast.Subtype;
import zserio.ast.UnionType;
import zserio.emit.common.DefaultEmitter;
import zserio.emit.common.ZserioEmitException;

public class SampleEmitter extends DefaultEmitter
{
    @Override
    public void beginPackage(Package packageToken) throws ZserioEmitException
    {
        System.out.println("  package " + packageToken.getPackageName());
    }

    @Override
    public void beginImport(Import importNode) throws ZserioEmitException
    {
        System.out.println("    import " + importNode.getImportedPackageName());
    }

    @Override
    public void beginConst(Constant constant) throws ZserioEmitException
    {
        System.out.println("    const " + constant.getName());
    }

    @Override
    public void beginSubtype(Subtype subType) throws ZserioEmitException
    {
        System.out.println("    subtype " + subType.getName());
    }

    @Override
    public void beginStructure(StructureType structureType) throws ZserioEmitException
    {
        System.out.println("    structure " + structureType.getName());
        printCompoundField(structureType);
    }

    @Override
    public void beginChoice(ChoiceType choiceType) throws ZserioEmitException
    {
        System.out.println("    choice " + choiceType.getName());
        printCompoundField(choiceType);
    }

    @Override
    public void beginUnion(UnionType unionType) throws ZserioEmitException
    {
        System.out.println("    union " + unionType.getName());
        printCompoundField(unionType);
    }

    @Override
    public void beginEnumeration(EnumType enumType) throws ZserioEmitException
    {
        System.out.println("    enum " + enumType.getName());
    }

    @Override
    public void beginBitmask(BitmaskType bitmaskType) throws ZserioEmitException
    {
    	System.out.println("    bitmask " + bitmaskType.getName());
    }

    @Override
    public void beginSqlTable(SqlTableType sqlTableType) throws ZserioEmitException
    {
        System.out.println("    sql_table " + sqlTableType.getName());
        printCompoundField(sqlTableType);
    }

    @Override
    public void beginSqlDatabase(SqlDatabaseType sqlDatabaseType) throws ZserioEmitException
    {
        System.out.println("    sql_database " + sqlDatabaseType.getName());
        printCompoundField(sqlDatabaseType);
    }

    @Override
    public void beginService(ServiceType serviceType) throws ZserioEmitException
    {
        System.out.println("    service " + serviceType.getName());
    }

    @Override
    public void beginPubsub(PubsubType pubsubType) throws ZserioEmitException
    {
        System.out.println("    pubsub " + pubsubType.getName());
    }

    private void printCompoundField(CompoundType compoundType)
    {
        for (Field field : compoundType.getFields())
            System.out.println("      " + field.getTypeInstantiation().getType().getName() + " " +
            		field.getName());
    }
}
