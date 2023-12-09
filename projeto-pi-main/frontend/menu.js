const btn = document.getElementById('botao')
    const menu = document.getElementById('menu')

    btn.addEventListener("click", () => {
      menu.classList.toggle("hidden")
    })