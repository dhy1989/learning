package analyzer;


import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.library.DicLibrary;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.List;

/**
 * @author dinghy
 * @date 2020/6/23 09:29
 */
public class AnalyzerDemo {
    public static void test() {
        //只关注这些词性的词
//        Set<String> expectedNature = new HashSet<String>() {{
//            add("n");add("v");add("vd");add("vn");add("vf");
//            add("vx");add("vi");add("vl");add("vg");
//            add("nt");add("nz");add("nw");add("nl");
//            add("ng");add("userDefine");add("wh");
//        }};
        DicLibrary.insert(DicLibrary.DEFAULT,"");
        String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
        Result result = ToAnalysis.parse(str); //分词结果的一个封装，主要是一个List<Term>的terms
        System.out.println(result.getTerms());

        List<Term> terms = result.getTerms(); //拿到terms
        System.out.println(terms.size());

        for(int i=0; i<terms.size(); i++) {
            String word = terms.get(i).getName(); //拿到词
        //    String natureStr = terms.get(i).getNatureStr(); //拿到词性
            if(word.length()>1){
                System.out.println(word);
            }

        }
    }
    public static void main(String[] args) {
   test();
    }
}
