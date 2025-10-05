document.addEventListener("DOMContentLoaded", function() {
  const btnPesquisar = document.getElementById("btnPesquisarCliente");
  const inputId = document.getElementById("inputClienteId");
  const inputNome = document.getElementById("inputNome");
  const inputCpf = document.getElementById("inputCpf");
  const inputEmail = document.getElementById("inputEmail");
  const inputTelefone = document.getElementById("inputTelefone");
  
  if (!btnPesquisar) {
    console.error("btnPesquisarCliente não encontrado no DOM");
    return;
  }
  
  btnPesquisar.addEventListener("click", function() {
    const clienteId = inputId.value && inputId.value.trim();
    if (!clienteId) {
      alert("Informe um ID de cliente para pesquisar.");
      return;
    }

    const url = `/cliente/${encodeURIComponent(clienteId)}`;

    fetch(url)
      .then(response => {
        if (response.status === 404) return null;
        if (!response.ok) throw new Error("Resposta de rede não OK: " + response.status);
        const ct = response.headers.get("content-type") || "";
        if (!ct.includes("application/json")) {
          console.warn("Resposta não é JSON:", ct);
          return null;
        }
        return response.json();
      })
      .then(data => {
        if (!data) {
          inputNome.value = "";
          inputCpf.value = "";
          inputEmail.value = "";
          inputTelefone.value = "";
          console.log("Cliente não encontrado — pronto para cadastro.");
          return;
        }

        inputNome.value = data.nome || "";
        inputCpf.value = data.cpf || "";
        inputEmail.value = data.email || "";
        inputTelefone.value = data.telefone || "";
        console.log("Cliente carregado:", data);
      })
      .catch(err => {
        console.error("Erro ao buscar cliente:", err);
        alert("Erro ao buscar cliente — veja console.");
      });
  });
});

const inputProduto = document.querySelector("input[name='produto']");
const inputQuantidade = document.querySelector("input[name='quantidadeProduto']");
const valorTotal = document.getElementById("valorTotal");

inputProduto.addEventListener("input", function() {
    const nomeProduto = inputProduto.value;

    fetch(`/estoque/buscarPorNome?nome=${encodeURIComponent(nomeProduto)}`)
        .then(res => res.json())
        .then(data => {
            if(data) {
                const quantidade = parseInt(inputQuantidade.value) || 1;
                const total = quantidade * data.valor;
                valorTotal.textContent = "Valor total: R$ " + total.toFixed(2);
            } else {
                valorTotal.textContent = "Produto não encontrado";
            }
        });
});

inputQuantidade.addEventListener("input", function() {
    const nomeProduto = inputProduto.value;

    fetch(`/estoque/buscarPorNome?nome=${encodeURIComponent(nomeProduto)}`)
        .then(res => res.json())
        .then(data => {
            if(data) {
                const quantidade = parseInt(inputQuantidade.value) || 1;
                const total = quantidade * data.valor;
                valorTotal.textContent = "Valor total: R$ " + total.toFixed(2);
            }
        });
});

