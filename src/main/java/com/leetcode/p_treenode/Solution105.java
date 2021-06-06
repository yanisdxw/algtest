package com.leetcode.p_treenode;

import com.leetcode.po.TreeNode;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        // preorder 为空，直接返回 null
        if(p_start==p_end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[p_start]);
        //在中序遍历中找到根节点的位置
        int i_root_index = 0;
        for (int i = i_start; i < i_end; i++) {
            if(inorder[i]==preorder[p_start]){
                i_root_index = i;
            }
        }
        int leftNum = i_root_index - i_start;
        //递归的构造左子树
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);
        //递归的构造右子树
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
        return root;
    }

}

/**
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * 首先根据 preorder 找到根节点是 3
 *
 * 然后根据根节点将 inorder 分成左子树和右子树
 * 左子树
 * inorder [9]
 *
 * 右子树
 * inorder [15,20,7]
 *
 * 把相应的前序遍历的数组也加进来
 * 左子树
 * preorder[9]
 * inorder [9]
 *
 * 右子树
 * preorder[20 15 7]
 * inorder [15,20,7]
 *
 * 现在我们只需要构造左子树和右子树即可，成功把大问题化成了小问题
 * 然后重复上边的步骤继续划分，直到 preorder 和 inorder 都为空，返回 null 即可
 *
 * 事实上，我们不需要真的把 preorder 和 inorder 切分了，只需要用分别用两个指针指向开头和结束位置即可。
 * 注意下边的两个指针指向的数组范围是包括左边界，不包括右边界。
 *
 * 作者：windliang
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--22/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 作者：windliang
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--22/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */
