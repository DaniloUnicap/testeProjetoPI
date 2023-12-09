const axios = require('axios');

const url = 'http://localhost:8080/salas/escolas_publicas';
const colunaDesejada = 'temAuditorio'; // Substitua pelo nome da coluna desejada

async function getRepos() {
  try {
    let response = await axios.get(url);
    const data = response.data;

    // Calcular a soma de todos os valores iguais a 1 na coluna desejada
    const soma = data.reduce((acc, item) => acc + item[colunaDesejada], 0);

    console.log(`A soma dos valores iguais a 1 na coluna ${colunaDesejada} é: ${soma}`);
  } catch (error) {
    console.error('Erro ao obter dados:', error.message);
  }
}

getRepos();