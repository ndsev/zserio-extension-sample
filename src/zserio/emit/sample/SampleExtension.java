package zserio.emit.sample;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import zserio.ast.Root;
import zserio.emit.common.ZserioEmitException;
import zserio.tools.Extension;
import zserio.tools.Parameters;

public class SampleExtension implements Extension
{
    @Override
    public String getName()
    {
        return "Sample Generator";
    }

    @Override
    public String getVersion()
    {
        return VERSION_STRING;
    }

    @Override
    public void registerOptions(Options options)
    {
        final Option option = new Option(OPTION_SAMPLE, false, "print AST nodes on standard output");
        option.setRequired(false);
        options.addOption(option);
    }

    @Override
    public boolean isEnabled(Parameters parameters)
    {
        return parameters.argumentExists(OPTION_SAMPLE);
    }

    @Override
    public void generate(Parameters parameters, Root rootNode) throws ZserioEmitException
    {
        final SampleEmitter sampleEmitter = new SampleEmitter();
        rootNode.emit(sampleEmitter);
    }

    private final static String VERSION_STRING = "2.0.0-pre3";
    private final static String OPTION_SAMPLE = "sample";
}
