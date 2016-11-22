package org.wltea.analyzer.lucene;

import java.util.Map;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;

/**
 * IKAnalyzerSolrFactory.java
 *
 * @Description : IkAnalyzer Solr 索引采用细粒度分词，查询采取最大分词
 * @Author huangzhiwei
 * @DATE 2016/11/22
 */
public class IKAnalyzerSolrFactory extends TokenizerFactory{

    private boolean useSmart;

    public boolean useSmart() {
        return useSmart;
    }

    public void setUseSmart(boolean useSmart) {
        this.useSmart = useSmart;
    }

    public IKAnalyzerSolrFactory(Map<String,String> args) {
        super(args);
        this.setUseSmart(args.get("useSmart").toString().equals("true"));
    }

    @Override
    public Tokenizer create(AttributeFactory factory) {
        Tokenizer _IKTokenizer = new IKTokenizer(factory , this.useSmart);
        return _IKTokenizer;
    }

}
