<h1 id="close_look_java" align="center">CLose Look Java</h1>

<p align="center">
    <a href="#DataStructure">
        <img src="https://img.shields.io/badge/Content-Datastructure-orange" alt="Datastructure">
    </a>
    <a href="#Algorithm">
        <img src="https://img.shields.io/badge/Content-Algorithm-orange" alt="Algorithm">
    </a>
    <a href="#GraphTheory">
        <img src="https://img.shields.io/badge/Content-graph-orange" alt="graph">
    </a>
    <a href="http://www.apache.org/licenses/">
        <img src="https://img.shields.io/badge/license-Apache-blue" alt="GitHub">
    </a>
    <a href="https://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html">
        <img src="https://img.shields.io/badge/Java-8-blue" alt="Java 8">
    </a>
</p>
 
<p align="center">
    <a href="#clipboard-getting-started">快速开始 -- Getting Started</a> •
    <a href="#about">关于 -- About</a> •
    <a href="#table-of-contents">目录 -- Table of Contents</a> •
    <a href="#acknowledgment">鸣谢 -- Acknowledgment</a> •
    <a href="#speech_balloon-faq">问答 -- FAQ</a> •
</p>

<h6 align="center">Made by ximing Xing • :milky_way: 
<a href="https://ximingxing.github.io/">https://ximingxing.github.io/</a>
</h6>

本项目所有的数据结构，算法和图论内容都是基于Java语言，使用了Java语言范型等特性。
本项目基于Maven构建，将源代码与测试代码解耦。
目标：构建自己的Java Collection 并拥有更多的算法。
已在Java8版本完成测试✅

A series of data structures and algorithms implemented using the Java language.

Aim to built Java Collection and more than Collection.

Open Source runs on love, laughter and a whole lot of coffee. Consider buying me one if you find this content useful ☕️😉.

<h2 align="center">:clipboard: 快速开始 -- Getting Started</h2>

* 源代代码在`Close-Look-Java/src/main/java` -- the source code in the `Close-Look-Java/src/main/java` directory.

* 测试代码在`Close-Look-Java/src/test/java` -- the test code in the `Close-Look-Java/src/test/java` directory.

- Search for a specific Code. Can't find one? Please report a new Code [here](https://github.com/ximingxing/Close-Look-Java/issues).

<h2 align="center">关于 -- About</h2>

A series of data structures implemented using the Java language.

Project language level is 8 , build by Maven.

With your questions, comments or even if you just want to say Hi.

<h2 align="center">目录 -- Table of Contents</h2>
<p align="right"><a href="#close_look_java"><sup>▴ Back to top</sup></a></p>

## DataStructure

* [Dynamic Array](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/datastructure/array/Array.java)
* [LinkedList](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/datastructure/linkedlist/LinkedList.java)
* Stack
    * [ArrayStack](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/datastructure/stack/ArrayStack.java)
    * [LinkedListStack](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/datastructure/stack/LinkedListStack.java)
* Queue
    * [ArrayQueue](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/datastructure/queue/ArrayQueue.java)
    * [LinkedListQueue](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/datastructure/queue/LinkedListQueue.java)
    * [LoopQueue](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/datastructure/queue/LoopQueue.java)
    * [PriorityQueue](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/datastructure/heap/PriorityQueue.java)
* Tree
    * [BinarySearchTree](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/datastructure/tree/BST.java)
    * [SegmentTree](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/datastructure/tree/SegmentTree.java)
* Set
    * [LinkedLIstSet](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/datastructure/set/LinkedListSet.java)
    * [BSTSet](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/datastructure/set/BSTSet.java)
* Map
    * [LinkedListMap](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/datastructure/map/LinkedListMap.java)
    * [BSTMap](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/datastructure/map/BSTMap.java)
* Heap
    * [MaxHeap](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/datastructure/heap/MaxHeap.java)

## Algorithm

* recursion -- 递归算法遍布在链表和树结构的遍历中

* Depth-first Search
    * [DFS recursion](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/graph/dfs/GraphDFS.java)
    * [DFS non-recursion](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/graph/dfs/GraphDFSnr.java)

## GraphTheory

* Build Graph
    * [Adjacent Matrix](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/graph/basic/AdjMatrix.java)
    * [Adjacent LinkedList](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/graph/basic/AdjList.java)
    * [Adjacent TreeSet](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/graph/basic/AdjSet.java)
    
* Depth-first Search
    * [DFS recursion](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/graph/dfs/GraphDFS.java)
    * [DFS non-recursion](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/graph/dfs/GraphDFSnr.java)
    * [connected component](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/graph/dfs/ConnectedComponent.java)
    * [single source path](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/graph/dfs/SingleSourcePath.java)
    * [all pair path](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/graph/dfs/AllPairPath.java)
    * [path](https://github.com/ximingxing/Close-Look-Java/blob/master/src/main/java/graph/dfs/Path.java)

<h2 align="center">鸣谢 -- Acknowledgment</h2>
<p align="right"><a href="#close_look_java"><sup>▴ Back to top</sup></a></p>

<h2 align="center">:speech_balloon: 问答 -- FAQ</h2>
<p align="right"><a href="#close_look_java"><sup>▴ Back to top</sup></a></p>
