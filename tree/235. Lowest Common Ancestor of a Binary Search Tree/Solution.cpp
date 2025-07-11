

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution
{
public:
    TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q)
    {
        int val = root->val;
        int pVal = p->val;
        int qVal = q->val;
        if (pVal < val && qVal < val)
        {
            return lowestCommonAncestor(root->left, p, q);
        }
        else if (pVal > val && qVal > val)
        {
            return lowestCommonAncestor(root->right, p, q);
        }
        else
        {
            return root;
        }
    }
};