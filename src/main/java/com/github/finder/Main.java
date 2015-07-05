package com.github.finder;

import java.util.Iterator;
import java.util.List;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

//Main クラスを作成する
public class Main{
    public Main(String[] arguments){
    }

    public static void main(String[] args){
        new Main(args);
    }
}

//Args�̍쐬
public class Args implements Iterable<String>{
    @Argument(metaVar="DIRS")
    private List<String> targets;

    @Option(name="-name", metaVar="<NAME>")
    private String name;

    @Option(name="-type", metaVar="<TYPE>")
    private String type;

    @Option(name="-size", metaVar="<SIZE>")
    private String size;

    @Option(name="-grep", metaVar="<PATTERN>")
    private String grep;

    @Override
    public Iterator<String> iterator(){
        return targets.iterator();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public String getGrep() {
        return grep;
    }
}

//�R�}���h���C���I�v�V��������͂��鏈��
private Args parseArguments(String[] arguments){
        Args args = new Args();
        try {
            CmdLineParser parser = new CmdLineParser(args);
            parser.parseArgument(arguments);
        } catch (CmdLineException e) {
        }
        return args;
    }
