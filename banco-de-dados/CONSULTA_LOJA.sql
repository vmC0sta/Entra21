/* Criar uma consulta para listar o nome do produto, a quantidade vendida, o valor unitário de cada item */

SELECT B.NOME, A.QUANTIDADE 'QUANTIDADE_VENDIDA', A.VALORUNITARIO
FROM LJ_VENDAITEM A
INNER JOIN LJ_PRODUTO B ON B.HANDLE = A.PRODUTO

/* Criar uma consulta para listar a data da venda e para qual cliente foi realizada a venda */

SELECT DATA 'DATA VENDA', B.NOME 'CLIENTE'
FROM LJ_VENDA A
INNER JOIN LJ_PESSOA B ON B.HANDLE = A.CLIENTE

/* Listar o código, descrição, nome da categoria e nome do fornecedor de produtos */

SELECT A.SKU, A.NOME, B.NOME 'CATEGORIA', C.NOME 'FORNECEDOR'
FROM LJ_PRODUTO A
INNER JOIN LJ_CATEGORIA B ON B.HANDLE = A.CATEGORIA
INNER JOIN LJ_PESSOA C ON C.HANDLE = A.FORNECEDOR