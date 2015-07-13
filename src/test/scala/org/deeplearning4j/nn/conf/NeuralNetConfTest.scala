package org.deeplearning4j.nn.conf

import org.deeplearning4j.nn.api.OptimizationAlgorithm
import org.deeplearning4j.nn.conf.distribution.{Distribution, NormalDistribution}
import org.deeplearning4j.nn.conf.layers.{ConvolutionLayer, Layer, RBM}
import org.deeplearning4j.nn.conf.stepfunctions.StepFunction
import org.deeplearning4j.nn.weights.WeightInit
import org.deeplearning4s.nn.conf.LossFunction.Max
import org.deeplearning4s.nn.conf.{ActivationFunction, NeuralNetConf, Sigmoid}
import org.scalatest.FlatSpec

import scala.collection.JavaConverters._

class NeuralNetConfTest extends FlatSpec {
  "NeuralNetConf" should "set each property to MultiLayerConfiguration instance correctly" in {
    val layer: Layer = new Layer {}
    val sparsity: Double = 2f
    val useAdaGrad: Boolean = false
    val learningRate: Double = 1e-2D
    val k: Int = 2
    val corruptionLevel: Double = 3e-2D
    val numIterations: Int = 200
    val momentum: Double = 1D
    val l2: Double = 1f
    val useRegularization: Boolean = true
    val momentumAfter: Map[Int, Double] = Map(1 -> 1.0D)
    val resetAdaGradIterations: Int = -2
    val dropOut: Double = 1
    val applySparsity: Boolean = true
    val weightInit: WeightInit = WeightInit.UNIFORM
    val optimizationAlgo: OptimizationAlgorithm = OptimizationAlgorithm.HESSIAN_FREE
    val lossFunction = Max
    val constrainGradientToUnitNorm: Boolean = true
    val seed: Long = System.currentTimeMillis()
    val dist: Distribution = new NormalDistribution(1e-3, 1)
    val nIn: Int = 0
    val nOut: Int = 0
    val activationFunction: ActivationFunction = Sigmoid
    val visibleUnit: RBM.VisibleUnit = RBM.VisibleUnit.BINARY
    val hiddenUnit: RBM.HiddenUnit = RBM.HiddenUnit.BINARY
    val weightShape: Array[Int] = Array(2)
    val filterSize: Array[Int] = Array(1)
    val stride: Array[Int] = Array(3)
    val featureMapSize: Array[Int] = Array(1, 1)
    val kernel: Int = 6
    val batchSize: Int = 200
    val numLineSearchIterations: Int = 200
    val minimize: Boolean = true
    val convolutionType: ConvolutionLayer.ConvolutionType = ConvolutionLayer.ConvolutionType.SUM
    val l1: Double = 1.0D
    val rmsDecay: Double = 1f
    val stepFunction: StepFunction = new StepFunction

    val conf = NeuralNetConf(layer, sparsity, useAdaGrad, learningRate, k, corruptionLevel, numIterations, momentum, l2, useRegularization,
      momentumAfter, resetAdaGradIterations, dropOut, applySparsity, weightInit, optimizationAlgo,
      lossFunction, constrainGradientToUnitNorm, seed, dist, nIn, nOut,
      activationFunction, visibleUnit, hiddenUnit, weightShape, filterSize,
      stride, featureMapSize, kernel, batchSize, numLineSearchIterations, minimize,
      convolutionType, l1, rmsDecay, stepFunction).asJava

    assert(conf.layer == layer)
    assert(conf.getSparsity == sparsity)
    assert(conf.isUseAdaGrad == useAdaGrad)
    assert(conf.getLr == learningRate)
    assert(conf.k == k)
    assert(conf.corruptionLevel == corruptionLevel)
    assert(conf.numIterations == numIterations)
    assert(conf.momentum == momentum)
    assert(conf.l2 == l2)
    assert(conf.useRegularization == useRegularization)
    assert(conf.momentumAfter.asScala == momentumAfter)
    assert(conf.resetAdaGradIterations == resetAdaGradIterations)
    assert(conf.dropOut == dropOut)
    assert(conf.applySparsity == applySparsity)
    assert(conf.getWeightInit == weightInit)
    assert(conf.optimizationAlgo == optimizationAlgo)
    assert(conf.lossFunction == lossFunction.value)
    assert(conf.constrainGradientToUnitNorm == constrainGradientToUnitNorm)
    assert(conf.seed == seed)
    assert(conf.dist == dist)
    assert(conf.nIn == nIn)
    assert(conf.nOut == nOut)
    assert(conf.activationFunction == activationFunction.name)
    assert(conf.getVisibleUnit == visibleUnit)
    assert(conf.getHiddenUnit == hiddenUnit)
    assert(conf.getWeightShape == weightShape)
    assert(conf.getFilterSize == filterSize)
    assert(conf.getStride == stride)
    assert(conf.featureMapSize == featureMapSize)
    assert(conf.getKernel == kernel)
    assert(conf.batchSize == batchSize)
    assert(conf.numLineSearchIterations == numIterations)
    assert(conf.minimize == minimize)
    assert(conf.convolutionType == convolutionType)
    assert(conf.l1 == l1)
    assert(conf.getCustomLossFunction == lossFunction.name)
    assert(conf.rmsDecay == rmsDecay)
    assert(conf.stepFunction == stepFunction)
  }
}
