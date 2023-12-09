document.addEventListener("DOMContentLoaded", function () {
  // Obtenha o contexto do canvas e configure o gráfico
  async function createChart1() {
  const aguaArray = await getDataForAguaChart();
  const energiaArray = await getDataForEnergiaChart();
  const lixoArray = await getDataForLixoChart();

  const ctx = document.getElementById('barChart');

  new Chart(ctx, {
    type: 'bar',
    data: {
      labels: ['Agua Potável', 'Tratamento de lixo','Energia da rede pública'],
      datasets: [{
        label: 'Quantidade',
        data: [
          aguaArray.somaColunaTemAguaPotavel,
          lixoArray.somaColunaTemLixo,
          energiaArray.somaColunaTemEnergia
          
        ],
        borderWidth: 1
      }]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      },
      maintainAspectRatio: false, 
    }
  });
  document.getElementById("spin").style.display = "none";
}
createChart1();

});



  
document.addEventListener("DOMContentLoaded", function () {
  // Obtenha o contexto do canvas e configure o gráfico
  async function createChart2() {
    const computadores = await getDataForTIChart();
    const computadoresZero = await getDataForTIZeroChart();
    const computadoresNulo = await getDataForTINullChart();
 
    const ctx2 = document.getElementById('pieChart');
  
    new Chart(ctx2, {
      type: 'pie',
      data: {
        labels: ['Escolas com computadores', 'Escolas sem computadores', 'Escolas sem informação sobre computadores'],
        datasets: [{
          label: 'Quantidade',
          data: [
            computadores.somaColunaTemComputador,
            computadoresZero.quantidadeZeros,
            computadoresNulo.quantidadeNulos
          ],
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        },
        maintainAspectRatio: false, 
      }
    });
    document.getElementById("spin2").style.display = "none";
  }
  
  createChart2();;

});



document.addEventListener("DOMContentLoaded", function () {
  // Obtenha o contexto do canvas e configure o gráfico
  async function createChart() {
    const testeArray = await getDataForSalasChart();
  
    const ctx = document.getElementById('lineChart');
  
    new Chart(ctx, {
      type: 'line',
      data: {
        labels: ['Auditório', 'Biblioteca', 'Laboratório Ciências', 'Laboratório de Informática'],
        datasets: [{
          label: 'Quantidade',
          data: [
            testeArray.somaColunaTemAuditorio,
            testeArray.somaColunaTemBiblioteca,
            testeArray.somaColunaTemLabCiencias,
            testeArray.somaColunaTemLabInformatica
          ],
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        },
        maintainAspectRatio: false, 
      }
    });
    document.getElementById("spin3").style.display = "none";
  }
  createChart();;

});
  
  
  