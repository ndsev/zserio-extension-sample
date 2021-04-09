package zserio.extension.sample;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import zserio.ast.Root;
import zserio.extension.common.ZserioExtensionException;
import zserio.tools.Extension;
import zserio.tools.ExtensionParameters;

/**
 * The sample extension.
 *
 * It just prints Zserio types defined in the schema to the standard otuput.
 */
public class SampleExtension implements Extension
{
    @Override
    public String getName()
    {
        return "Sample";
    }

    @Override
    public String getVersion()
    {
        return ZSERIO_VERSION_STRING;
    }

    @Override
    public void registerOptions(Options options)
    {
        final Option option = new Option(OPTION_SAMPLE, false, "print AST nodes on standard output");
        option.setRequired(false);
        options.addOption(option);
    }

    @Override
    public boolean isEnabled(ExtensionParameters parameters)
    {
        return parameters.argumentExists(OPTION_SAMPLE);
    }

    @Override
    public void process(Root rootNode, ExtensionParameters parameters) throws ZserioExtensionException
    {
        final SampleEmitter sampleEmitter = new SampleEmitter();
        rootNode.walk(sampleEmitter);
    }

    private final static String EXTENSION_VERSION_STRING = "0.1.0";
    private final static String ZSERIO_VERSION_STRING = "2.3.0";
    private final static String OPTION_SAMPLE = "sample";
}
