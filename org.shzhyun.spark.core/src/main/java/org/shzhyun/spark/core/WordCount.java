package org.shzhyun.spark.core;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;

/**
 * Created by hadoop on 17-6-11.
 */
public class WordCount {
    private static final Pattern SPACE = Pattern.compile(" ");

    public static void main(String[] args)throws Exception {
        SparkConf sparkConf = new SparkConf().setAppName("SparkWordCount");
        String srcPath = "/users/geds/input/";
        String desPath = "/users/geds/output/";
        if(args.length == 2) {
            srcPath = args[0];
            desPath = args[1];
        }
        JavaSparkContext jsc = new JavaSparkContext(sparkConf);
        JavaRDD<String> lines = jsc.textFile(srcPath, 1);

        System.out.println("file text split!");
        JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(s.split(" ")).iterator();
            }
            /*@Override
            public Iterable<String> call(String s) throws Exception {
                return Arrays.asList(SPACE.split(" "));
            }*/
        });

        System.out.println("word map!");
        JavaPairRDD<String, Integer> ones = words.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<String, Integer>(s, 1);
            }
        });

        System.out.println("word reduce!");
        JavaPairRDD<String, Integer> counts = ones.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer i1, Integer i2) throws Exception {
                return i1 + i2;
            }
        });

        System.out.println("word count save!");
        counts.saveAsTextFile(desPath);
        jsc.stop();
    }
}