package com.bigdata.spark;

import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;

/**
 * @author dongyl
 * @date 12:29 11/27/17
 * @project study-demo
 */
public class DenseVecDemo {
    Vector denseVec1 = Vectors.dense(1.0, 2.0, 3.0);
    Vector denseVec2 = Vectors.dense(new double[] {1.0, 2.0, 3.0});
    // 创建稀疏向量<1.0, 0.0, 2.0, 0.0>;该方法只接收
    // 向量的维度(这里是4)以及非零位的位置和对应的值
    Vector sparseVec1 = Vectors.sparse(4, new int[] {0, 2}, new double[]{1.0, 2.0});

}
