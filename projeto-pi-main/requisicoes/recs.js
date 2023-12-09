// dbQuery.js

async function getDataForSalasChart() {
  const urlSalas = 'https://projeto-pi-production.up.railway.app/salas';
  const colunaAuditorio = 'temAuditorio';
  const colunaBiblioteca = 'temBiblioteca';
  const colunaLabCiencias = 'temLaboratorioCiencias';
  const colunaLabInformatica = 'temInformatica';

  const testeArray = {};

  await getRepos(urlSalas, colunaAuditorio)
    .then(somaColunaTemAuditorio => {
      testeArray.somaColunaTemAuditorio = somaColunaTemAuditorio;
      console.log(`Soma da coluna ${colunaAuditorio} para a URL ${urlSalas}: ${somaColunaTemAuditorio}`);
    });

  await getRepos(urlSalas, colunaBiblioteca)
    .then(somaColunaTemBiblioteca => {
      testeArray.somaColunaTemBiblioteca = somaColunaTemBiblioteca;
      console.log(`Soma da coluna ${colunaBiblioteca} para a URL ${urlSalas}: ${somaColunaTemBiblioteca}`);
    });

  await getRepos(urlSalas, colunaLabCiencias)
    .then(somaColunaTemLabCiencias => {
      testeArray.somaColunaTemLabCiencias = somaColunaTemLabCiencias;
      console.log(`Soma da coluna ${colunaLabCiencias} para a URL ${urlSalas}: ${somaColunaTemLabCiencias}`);
    });

  await getRepos(urlSalas, colunaLabInformatica)
    .then(somaColunaTemLabInformatica => {
      testeArray.somaColunaTemLabInformatica = somaColunaTemLabInformatica;
      console.log(`Soma da coluna ${colunaLabInformatica} para a URL ${urlSalas}: ${somaColunaTemLabInformatica}`);
    });

  return testeArray;
}

async function getDataForTIChart() {
  const urlTI = 'https://projeto-pi-production.up.railway.app/ti';
  const colunaTI = 'temComputador';

  const computadores = {};

  await getRepos(urlTI, colunaTI)
    .then(somaColunaTemComputador => {
      computadores.somaColunaTemComputador = somaColunaTemComputador;
      console.log(`Soma da coluna ${colunaTI} para a URL ${urlTI}: ${somaColunaTemComputador}`);
    });

  return computadores;
}

async function getDataForTIZeroChart () {
  const urlTI = 'https://projeto-pi-production.up.railway.app/ti';
  const colunaTI = 'temComputador';

  const computadoresZero = {}

  await contarZerosNaColuna(urlTI, colunaTI)
    .then(quantidadeZeros => {
      computadoresZero.quantidadeZeros = quantidadeZeros;
      console.log(`Quantidade de zeros na coluna ${colunaTI} para a URL ${urlTI}: ${quantidadeZeros}`);
    });

    return computadoresZero;
}

async function getDataForTINullChart() {
  const urlTI = 'https://projeto-pi-production.up.railway.app/ti';
  const colunaTI = 'temComputador';

  const computadoresNull = {};

  await contarNulosNaColuna(urlTI, colunaTI)
    .then(quantidadeNulos => {
      computadoresNull.quantidadeNulos = quantidadeNulos;
      console.log(`Quantidade de nulos na coluna ${colunaTI} para a URL ${urlTI}: ${quantidadeNulos}`);
    });

  return computadoresNull;
}

async function getDataForAguaChart() {
  const urlRecursos = 'https://projeto-pi-production.up.railway.app/recursos_basicos';
  const colunaAgua = 'temAguaPotavel';

  const agua = {};

  await getRepos(urlRecursos, colunaAgua)
    .then(somaColunaTemAguaPotavel => {
      agua.somaColunaTemAguaPotavel = somaColunaTemAguaPotavel;
      console.log(`Soma da coluna ${colunaAgua} para a URL ${urlRecursos}: ${somaColunaTemAguaPotavel}`);
    });

  return agua;
}
async function getDataForEnergiaChart() {
  const urlRecursos = 'https://projeto-pi-production.up.railway.app/recursos_basicos';
  const colunaEnergia = 'temEnergiaRedePublica';

  const energia = {};

  await getRepos(urlRecursos, colunaEnergia)
    .then(somaColunaTemEnergia => {
      energia.somaColunaTemEnergia = somaColunaTemEnergia;
      console.log(`Soma da coluna ${colunaEnergia} para a URL ${urlRecursos}: ${somaColunaTemEnergia}`);
    });

  return energia;
}

async function getDataForLixoChart() {
  const urlLixo = 'https://projeto-pi-production.up.railway.app/lixo_esgoto';
  const colunaLixo = 'temTratamentoLixoSeparacao';

  const lixo = {};

  await getRepos(urlLixo, colunaLixo)
    .then(somaColunaTemLixo => {
      lixo.somaColunaTemLixo = somaColunaTemLixo;
      console.log(`Soma da coluna ${colunaLixo} para a URL ${urlLixo}: ${somaColunaTemLixo}`);
    });

  return lixo;
}

async function getRepos(url, colunaDesejada) {
  try {
    const response = await axios.get(url);
    const data = response.data;

    const soma = data.reduce((acc, item) => {
      const valor = item[colunaDesejada];
      return valor !== null && valor !== undefined ? acc + valor : acc;
    }, 0);

    return soma;
  } catch (error) {
    console.error('Erro ao obter dados:', error.message);
    return 0;
  }
}

async function contarZerosNaColuna(url, colunaDesejada) {
  try {
    const response = await axios.get(url);
    const data = response.data;

    const quantidadeZeros = data.reduce((acc, item) => {
      const valor = item[colunaDesejada];
      return valor === 0 ? acc + 1 : acc;
    }, 0);

    return quantidadeZeros;
  } catch (error) {
    console.error('Erro ao obter dados:', error.message);
    return 0;
  }
}

async function contarNulosNaColuna(url, colunaDesejada) {
  try {
    const response = await axios.get(url);
    const data = response.data;

    const quantidadeNulos = data.reduce((acc, item) => {
      const valor = item[colunaDesejada];
      return valor === null ? acc + 1 : acc;
    }, 0);

    return quantidadeNulos;
  } catch (error) {
    console.error('Erro ao obter dados:', error.message);
    return 0;
  }
}

// Exporta as funções para serem utilizadas em outros arquivos
window.getDataForSalasChart = getDataForSalasChart;
window.getDataForTIChart = getDataForTIChart;
window.getDataForTINullChart = getDataForTINullChart;