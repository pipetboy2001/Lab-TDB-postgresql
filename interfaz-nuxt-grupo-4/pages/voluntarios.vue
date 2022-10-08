<script>
location.reload()
</script>
<template>
  <div class="container">
    <h1>Modulo voluntarios</h1>
    <button type="button" class="btn btn-primary" v-on:click="añadir()">Añadir</button>
    <div>
      ---
    </div>
    <!--Bootstrp table-->
    <table class="table table-hover table-striped table-dark table-bordered table-secondary">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">NOMBRE DEL VOLUNTARIO</th>
          <th scope="col">FECHA DE NACIMIENTO</th>
          <th scope="col">ACCIONES</th>
        </tr>
      </thead>
      <tbody>
        <tr scope="row" v-for="voluntario in pagina" :key="voluntario.id">
          <td>{{ voluntario.id }}</td>
          <td>{{ voluntario.nombre }}</td>
          <td>{{ voluntario.fnacimiento }}</td>
          <td>
            <!--Botones-->
            <button v-on:click="editar(voluntario.id)" type="button" class="btn btn-warning ">Editar</button>
            <button v-on:click="borrar(voluntario.id)" type="button " class="btn btn-danger ">Borrar</button>
          </td>
        </tr>
      </tbody>
    </table>
    <div></div>
    <button type="button" class="btn btn-danger" v-on:click="borrarTodos()">Eliminar todos</button>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'voluntariosView',
  data () {
    return {
      listaVoluntarios: [],
      pagina: 1
    }
  },
  methods: {
    editar (id) {
      this.$router.push('/voluntarios-edit?id=' + id)
    },
    borrar (id) {
      this.$router.push('/voluntarios-delete?id=' + id)
    },
    añadir () {
      this.$router.push('/voluntarios-create')
    },
    borrarTodos () {
      axios.delete('http://localhost:3000/voluntarios')
        .then(datos => {
          console.log(datos)
          alert('Voluntarios eliminados con exito')
          location.reload()
        }).catch(error => {
          console.log(error)
          this.makeToast('Error', 'No se pudo agregar el voluntario', 'error')
        })
    }

  },
  mounted: function () {
    const url = 'http://localhost:3000/voluntarios' + this.listaVoluntarios
    axios.get(url).then(data => {
      this.pagina = data.data
    })
  }
}
</script>