class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        for (int[] course: prerequisites){
            preMap.get(course[0]).add(course[1]);
        }
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, visited, preMap)){
                return false;
            } 
        }
        return true;
    }
    public boolean dfs(Integer curCourse, Set<Integer> visited, Map<Integer, List<Integer>> preMap){
        if (visited.contains(curCourse)){
            return false;
        }
        if (preMap.get(curCourse).isEmpty()){
            return true;
        }
        visited.add(curCourse);
        for (int course: preMap.get(curCourse)){
            if (!dfs(course, visited, preMap)){
                return false;
            } 
        }
        visited.remove(curCourse);
        preMap.put(curCourse, new ArrayList<>());
        return true;
    }
}

