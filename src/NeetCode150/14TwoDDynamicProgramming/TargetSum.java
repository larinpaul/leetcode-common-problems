//// 2023/08/24 // 13:07 //

//// 494. Target Sum // Medium //

// You are given an integer array nums and an integer target.

// You want to build an expression out of nums by adding one of the symbols '+' and '-' before each
// integer in nums and then concatenate all the integers.
// * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate
// them to build the expression "+2-1".

// Return the number of different expressions that you can build, which evaluates to target.

// Example 1:
// Input: nums = [1,1,1,1,1], target = 3
// Output: 5
// Explanation: There are 5 ways to assign symbols to make the sum of nums be
// target 3.
// - 1 + 1 + 1 + 1 + 1 = 3
// + 1 - 1 + 1 + 1 + 1 = 3
// + 1 + 1 - 1 + 1 + 1 = 3
// + 1 + 1 + 1 - 1 + 1 = 3
// + 1 + 1 + 1 + 1 - 1 = 3

// Example 2:
// Input: nums = [1], target = 1
// Output: 1

// Constraints:
// * 1 <= nums.length <= 20
// * 0 <= nums[i] <= 1000
// * 0 <= sum(nums[i]) <= 1000
// * -1000 <= target <= 1000


class TargetSum {

    // A questão 494. Target Sum é um problema de programação dinâmica que envolve
    // encontrar o número de maneiras the atribuir símbolos '+' e '-' aos elementos de um
    // array de inteiros, de modo que a soma resultante seja igual a um alvo dado.

    // Uma possível explicação para o problema é a seguinte:
    // * Podemos pensar em cada elemento do array como tendo um sinal positivo ou
    // negativo associado a ele, que indica se ele deve ser adicionado ou subtraído na
    // soma.
    // * Seja S a soma de todos os elementos do array com seus sinais originais, ou seja,
    // sem alterar nehum sinal. Por exemply, se o array for [1, 1, 1, 1, 1], então S = 5.
    // * Seja T o alvo dado. Por exemplo, se o alvo for 3, então T = 3.
    // * Seja D a diferença entre S e T, ou seja, D = S - T. Neste exemplo, D = 5 - 3 = 2.
    // * Podemos observar que D deve ser um número par, pois se fosse ímpar, não
    // haveria nehuma maneira de obter T a partir de S alterando alguns sinais. Isso se
    // deve ao fato de que cada mudança de sinal altera a soma um em múltiplo par de 2.
    // Por exemplo, se mudarmos o sinal do primeiro elemento de [1, 1, 1, 1, 1], a
    // soma passa de 5 para 3, uma diferença de 2. Se mudarmos o sinal do segundo
    // elemeto também, a soma passa de 3 para 1, uma diferença de mais 2.
    // * Se D for par, podemos dividir D por 2 e obter um novo valor P, que representa a
    // soma dos elementos que devem ter seus sinais alterados para obter T.
    // Neste exemplo, P = D / 2 = 2 / 2 = 3.
    // * Agora, o problema se resume a encontrar o número de subconjuntos do array que
    // somam P. Isso pode ser feito usando programação dinâmica, mantendo um array
    // unidimensional dp[j] que armazena o número de maneiras de obter uma soma j
    // usando os elementos do array. O array dp pode ser preenchido da seguinte forma:
    // ** Inicialize dp[0] = 1, pois há uma maneira de obter uma soma zero:
    // não escolher nenhum elemento.
    // ** Para cada elemento num do array:
    // *** Para cada j de P a num em ordem decrescente:
    // **** Atualize dp[j] = dp[j] + dp[j-num], pois podemos escolher incluir o
    //      elemento atual na soma.
    // ** Retorne dp[P] como a reposta final.

    // Uma possível solução ótima para o problem em Java é:
    public int findTargetSumWays(int[] nums, int target) {
        // Calcular a soma total dos elementos do array
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // Verificar se a diferença entre a soma e o alvo é par
        if ((sum - target) % 2 != 0) {
            // Não há nenhuma maneira de obter o alvo
            return 0;
        }
        // Calcular o valor P
        int P = (sum - target) / 2;
        // Verifical se P é positivo
        if (P < 0) {
            // Não há nenhuma maneira de ober o alvo
            return 0;
        }
        // Criar o array dp
        int[] dp = new int[P + 1];
        // Iniciar dp[0] = 1
        dp[0] = 1;
        // Preencher o array dp
        for (int num : nums) {
            for (int j = P; j >= num; j--) {
                // Podemos incluir o elemento atual na soma
                dp[j] += dp[j-num];
            }
        }
        // Retornar a resposta final
        return dp[P];
    }

    // A complexidade de tempo da solução é O(nP),
    // onde n é o tamanho do array e P é p valor calculado a partir da
    // diferença entre a soma e o alvo.

    // A complexidade de espaço da solução é O(P), pois usamos um array unidimensional
    // para armazenar os resultados intermediários.

}
