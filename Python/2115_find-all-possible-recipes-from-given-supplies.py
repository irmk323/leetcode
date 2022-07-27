# For each recipe, count its non-available ingredients as in degree; Store (non-available ingredient, dependent recipes) as HashMap;
# Store all 0-in-degree recipes into a list as the starting points of topological sort;
# # Use topogical sort to decrease the in degree of recipes, whenever the in-degree reaches 0, add it to return list.

class Solution:
    def findAllRecipes(self, recipes: List[str], ingredients: List[List[str]], supplies: List[str]) -> List[str]:
        available = set(supplies)
        # Counter()... count how many elements appear in the dict
        ans, ingredient_to_recipe, in_degree = [], defaultdict(set), Counter()
        # zip .. combine the list and list as tuple
        for rcp, ingredient in zip(recipes, ingredients):
            non_available = 0
            for ing in ingredient:
                if ing not in available:
                    non_available += 1
                    ingredient_to_recipe[ing].add(rcp)
            if non_available == 0:
                ans.append(rcp)
            else:
                in_degree[rcp] = non_available
        for rcp in ans:
            # topological sort
            for recipe in ingredient_to_recipe.pop(rcp, set()):
                in_degree[recipe] -= 1
                if in_degree[recipe] == 0:
                    ans.append(recipe)
        return ans