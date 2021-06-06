package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 * 输入：root = [1,2]
 * 输出：[1,2]
 */
public class Solution297 {
    public static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<String> ans = new ArrayList<>();
            if(root==null){
                return "";
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node==null){
                    ans.add("null");
                    continue;
                }else {
                    ans.add(String.valueOf(node.val));
                }
                queue.add(node.left);
                queue.add(node.right);

            }
            return ans.stream().collect(Collectors.joining(","));
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if("".equals(data)) return null;
            List<String> nums = Arrays.asList(data.split(","));
            if(nums.size()==0){
                return new TreeNode();
            }
            int index = 0;
            TreeNode root = new TreeNode(Integer.valueOf(nums.get(index++)));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(index<nums.size()){
                    String valstr = nums.get(index++);
                    if("null".equals(valstr)){
                        node.left = null;
                    }else {
                        node.left = new TreeNode(Integer.valueOf(valstr));
                        queue.offer(node.left);
                    }
                }
                if(index<nums.size()){
                    String valstr = nums.get(index++);
                    if("null".equals(valstr)){
                        node.right = null;
                    }else {
                        node.right = new TreeNode(Integer.valueOf(valstr));
                        queue.offer(node.right);
                    }
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode treeNode = codec.deserialize("");
        String treestr = codec.serialize(treeNode);
        System.out.println(treestr);
    }
}
