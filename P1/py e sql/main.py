from operacoesbd import *

conn = abrirBancoDados('localhost','root','12345','hamurabix')

opcao = 5
print('Bem-vindo ao Banco Hamurabix!')


while opcao != 4:
    print('1) Listar as contas, 2) Inserir uma nova conta, 3) Pesquisar por numero, 4 Sair')
    opcao = int(input('Digite sua opção '))

    if opcao == 1:
        print('Listagem')

        sql = "SELECT * FROM conta"
        resultado = listarBancoDados(conn, sql)

        for elemento in resultado:
            print(elemento)

    elif opcao == 2:
        print('Inserir nova conta')

        agencia = int(input('digite a agencia '))
        conta = int(input('digite a conta '))
        titular = input('digite o titular ')
        saldo = float(input('digite o saldo '))

        sql = "INSERT INTO conta(numero,agencia,saldo,titular) VALUES (%s, %s, %s, %s)"
        dados = (conta, agencia, saldo, titular)

        insertNoBancoDados(conn, sql, dados)

    elif opcao == 3:
        print('Pesquisar por número')

        numeroConta = input('Digite o numero da conta ')

        sql = "SELECT * FROM conta where numero = " + numeroConta
        print(sql)
        resultado = listarBancoDados(conn, sql)

        for elemento in resultado:
            print(elemento)



    elif opcao == 4:
        print('Inté!')

    else:
        print('Opção inválida!')

'''
sql = "SELECT * FROM conta"
resultado = listarBancoDados(conn,sql)

for elemento in resultado:
    print(elemento)
'''

'''
agencia = int(input('digite a agencia '))
conta = int(input('digite a conta '))
titular = input('digite o titular ')
saldo = float(input('digite o saldo '))

sql = "INSERT INTO conta(numero,agencia,saldo,titular) VALUES (%s, %s, %s, %s)"
dados = (conta,agencia,saldo,titular)

insertNoBancoDados(conn,sql,dados)
'''

'''
numeroContaParaExcluir = 123
sql = "DELETE FROM conta WHERE numero = %s"
dados = (numeroContaParaExcluir,)
linhasAfetadas = excluirBancoDados(conn,sql,dados)
print('Linhas afetadas: ',linhasAfetadas)
'''

'''
titular = 'Abella'
numeroConta = 124

sql = "UPDATE conta SET titular = %s WHERE numero = %s"
dados = (titular,numeroConta)

linhasAfetadas = atualizarBancoDados(conn,sql,dados)
print('Linhas afetadas: ',linhasAfetadas)
'''

encerrarBancoDados(conn)

