<template>
    <div>
        <h1>Editar Instituciones</h1>
    </div>

</template>

<script>
import axios from 'axios'
export default {
  data: function () {
    return {
      institucionId: null
    }
  },
  mounted: function () {
    this.institucionId = this.$route.params.id
    axios.get('http://localhost:3000/instituciones/' + this.institucionId).then(data => {
      console.log(data.data)
    })
  }
}
</script>
