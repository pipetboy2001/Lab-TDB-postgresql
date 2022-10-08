<script>
location.reload()
</script>

<template>
</template>


<script>
export default {
    data: function() {
        return {
            emergencias: [],
            voluntarios: [],
            rankings: [],
            loading: true,
            selected: {
                emergencia: [],
                voluntario: [],
                ranking: []
            }
        }
    },
    mounted() {
        this.loadEmergencia();
        this.loadVoluntario();
        this.loadRanking();
    },
    watch: {
        selected: {
            handler: function() {
                this.loading = true;
                this.loadEmergencia();
                this.loadVoluntario();
                this.loadRanking();
            },
            deep: true
        }
    },
    methods: {
        loadEmergencia: function () {
                axios.get('/api/emergencia', {
                        params: _.omit(this.selected, 'id')
                    })
                    .then((response) => {
                        this.emergencia = response.data.data;
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            },
        loadVoluntario: function () {
                axios.get('/api/voluntario', {
                        params: _.omit(this.selected, 'id')
                    })
                    .then((response) => {
                        this.voluntario = response.data.data;
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            },
        loadRanking: function () {
                axios.get('/api/ranking', {
                        params: _.omit(this.selected, 'id')
                    })
                    .then((response) => {
                        this.ranking = response.data.data;
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            }
    }
}
</script>
