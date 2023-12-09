// dbQuery.js

async function getDataForSalasPrivadasChart() {
    const urlSalas = 'http://localhost:8080/salas/escolas_privadas';
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
  
  async function getDataForTIPrivadasChart() {
    const urlTI = 'http://localhost:8080/ti/escolas_privadas';
    const colunaTI = 'temComputador';
  
    const computadores = {};
  
    await getRepos(urlTI, colunaTI)
      .then(somaColunaTemComputador => {
        computadores.somaColunaTemComputador = somaColunaTemComputador;
        console.log(`Soma da coluna ${colunaTI} para a URL ${urlTI}: ${somaColunaTemComputador}`);
      });
  
    return computadores;
  }
  
  async function getDataForTIZeroPrivadasChart () {
    const urlTI = 'http://localhost:8080/ti/escolas_privadas';
    const colunaTI = 'temComputador';
  
    const computadoresZero = {}
  
    await contarZerosNaColuna(urlTI, colunaTI)
      .then(quantidadeZeros => {
        computadoresZero.quantidadeZeros = quantidadeZeros;
        console.log(`Quantidade de zeros na coluna ${colunaTI} para a URL ${urlTI}: ${quantidadeZeros}`);
      });
  
      return computadoresZero;
  }
  
  async function getDataForTINullPrivadasChart() {
    const urlTI = 'http://localhost:8080/ti/escolas_privadas';
    const colunaTI = 'temComputador';
  
    const computadoresNull = {};
  
    await contarNulosNaColuna(urlTI, colunaTI)
      .then(quantidadeNulos => {
        computadoresNull.quantidadeNulos = quantidadeNulos;
        console.log(`Quantidade de nulos na coluna ${colunaTI} para a URL ${urlTI}: ${quantidadeNulos}`);
      });
  
    return computadoresNull;
  }
  
  async function getDataForAguaPrivadasChart() {
    const urlRecursos = 'http://localhost:8080/recursos_basicos/escolas_privadas';
    const colunaAgua = 'temAguaPotavel';
  
    const agua = {};
  
    await getRepos(urlRecursos, colunaAgua)
      .then(somaColunaTemAguaPotavel => {
        agua.somaColunaTemAguaPotavel = somaColunaTemAguaPotavel;
        console.log(`Soma da coluna ${colunaAgua} para a URL ${urlRecursos}: ${somaColunaTemAguaPotavel}`);
      });
  
    return agua;
  }
  async function getDataForEnergiaPrivadasChart() {
    const urlRecursos = 'http://localhost:8080/recursos_basicos/escolas_privadas';
    const colunaEnergia = 'temEnergiaRedePublica';
  
    const energia = {};
  
    await getRepos(urlRecursos, colunaEnergia)
      .then(somaColunaTemEnergia => {
        energia.somaColunaTemEnergia = somaColunaTemEnergia;
        console.log(`Soma da coluna ${colunaEnergia} para a URL ${urlRecursos}: ${somaColunaTemEnergia}`);
      });
  
    return energia;
  }
  
  async function getDataForLixoPrivadasChart() {
    const urlLixo = 'http://localhost:8080/lixo_esgoto/escolas_privadas';
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
  window.getDataForSalasPrivadasChart = getDataForSalasPrivadasChart;
  window.getDataForTIPrivadasChart = getDataForTIPrivadasChart;
  window.getDataForTINullPrivadasChart = getDataForTINullPrivadasChart;