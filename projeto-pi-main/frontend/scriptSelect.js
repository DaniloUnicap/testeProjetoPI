function redirectToUrl(selectElement) {
    var selectedOption = selectElement.options[selectElement.selectedIndex];
    var url = selectedOption.getAttribute('data-url');

    if (url) {
      window.location.href = url + ".html";
    }
  }