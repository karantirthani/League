package dsa.practice;

public class InternalTraverse {
    String findSubstring(Internal node, int startIndex, int length) {
        if (node.left == null && node.right==null) {
            String value = node.value;
            return value.substring(startIndex, startIndex + length);
        }
        StringBuilder result = new StringBuilder();
        int pendingLength = length;
        int rightIndex = startIndex;
        if (node.left != null) {
            if (node.left.length> startIndex) {
                int leftLength = node.left.length;
                if ((leftLength - startIndex) > length) {
                    pendingLength = 0;
                    result.append(findSubstring(node.left, startIndex, length));
                } else {
                    pendingLength = length - (leftLength - startIndex);
                    result.append(findSubstring(node.left, startIndex, leftLength-startIndex));
                    rightIndex = 0;
                }
            } else {
                rightIndex = rightIndex - node.left.length;
            }
        }
        if (pendingLength> 0 && node.right != null) {
            result.append(findSubstring(node.right, rightIndex, pendingLength));
        }
        return result.toString();
    }
}
