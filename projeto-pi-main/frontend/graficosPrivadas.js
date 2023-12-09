async function createChart1() {
    const aguaArray = await getDataForAguaPrivadasChart();
    const energiaArray = await getDataForEnergiaPrivadasChart();
    const lixoArray = await getDataForLixoPrivadasChart();
  
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
        }
      }
    });
  }
  createChart1();
    
  
  
  
    async function createChart2() {
      const computadores = await getDataForTIPrivadasChart();
      const computadoresZero = await getDataForTIZeroPrivadasChart();
      const computadoresNulo = await getDataForTINullPrivadasChart();
   
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
          }
        }
      });
    }
    
    createChart2();
    
  
    async function createChart() {
      const testeArray = await getDataForSalasPrivadasChart();
    
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
          }
        }
      });
    }
    createChart();