package assignment_examples;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import java.util.*;

public class Topo {
    public static void main(String[] args) {
        // Create tasks
        Task taskA = new TaskImpl("A");
        Task taskB = new TaskImpl("B");
        Task taskC = new TaskImpl("C");
        Task taskD = new TaskImpl("D");

        // Set dependencies
        // A ->  B 
        // ↓　   ↓
        // -->   C -> D

        taskA.addDependency(taskB);
        taskA.addDependency(taskC);
        taskB.addDependency(taskC);
        taskC.addDependency(taskD);

        // Create a set of tasks
        Set<Task> tasks = new HashSet<>(Arrays.asList(taskA, taskB, taskC, taskD));

        // Create executor and execute tasks
        Executor executor = new DFSExecutor();
        executor.execute(tasks);
    }
}

class TaskImpl implements Task {
    private String id;
    private Set<Task> deps;

    public TaskImpl(String id) {
        this.id = id;
        this.deps = new HashSet<>();
    }

     @Override
    public void addDependency(Task task) {
        deps.add(task);
    }

    @Override
    public void run() {
        System.out.println("Running task " + id);
    }

    @Override
    public Set<Task> getDeps() {
        return deps;
    }
    @Override
    public String toString(){
        return  "id " + id+ ",deps: " + deps.toString();
    }
}

class DFSExecutor implements Executor {
    private Map<Task, Boolean> visited;
    private Deque<Task> stack;

    public DFSExecutor(){
        this.visited = new HashMap<>();
        this.stack = new ArrayDeque<>();
    }
    @Override
    public void execute(Set<Task> tasks){
        for(Task task :tasks){
            visited.put(task, false);
        }
        for(Task task : tasks){
            if(!visited.get(task)){
                dfs(task);
                
            }
        }
        while(!stack.isEmpty()){
            stack.pop().run();
        }
    }
    private void dfs(Task task){
        visited.put(task,true);
        for(Task deps : task.getDeps()){
            if(visited.get(deps)){
                dfs(deps);
            }
        }
        stack.push(task);
    }

}

// Implement this interface
interface Executor {
  /**
   * Executes all the tasks in the parameter set, in the correct order.
   * Returns when all the tasks have been executed.
   */
  void execute(Set<Task> tasks); //
}

// The implementation of this interface is out of scope
// Interface cannot be changed
interface Task {
  /**
   * Executes the task and returns when the execution is complete.
   */
  void run();

  /**
   * Returns all the depenendencies of this task.
   * This means all the tasks that need to be executed before this task can be executed.
   */
  Set<Task> getDeps();
  void addDependency(Task task);
}

// We have a set of tasks that each of which have a set of dependencies, 
// tasks must be executed once. The following are a couple of examples:

// Example 1
// Input: {A, B}
// A > {C}
// B > {D}
// C > {D}


// Example 2
// Input: {A, B, C, D}
// A > {B, E}
// B > F
// C > {D, E}
// D > F
// E > F

// A -> B -> F
// A -> E -> F
// B
// C -> D -> F
// D

// A -> E -> F


// - Focus on code design and execution algorithm
// - Ask questions if anything is unclear