    class Solution {
        public String simplifyPath(String path) {
            Stack<String> stack = new Stack<>();
            StringBuffer sb = new StringBuffer();
            String[] strArr = path.split("/");
            int idx = 1;
            while(idx < strArr.length){
                if(strArr[idx].equals("..") ){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                }else if(strArr[idx].isEmpty() || strArr[idx].equals(".")){
                    idx++;
                    continue;
                }else {
                    stack.push(strArr[idx]);
                }
                idx++;
            }
            for(String str: stack){
                sb.append("/" + str);
            }
            return  sb.length() > 0? sb.toString() : "/";
        }
    }