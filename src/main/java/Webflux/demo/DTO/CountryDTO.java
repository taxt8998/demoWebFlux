package Webflux.demo.DTO;

public class CountryDTO {
    private String get;
    private String[] parameters;
    private String[] errors;
    private int results;
    private String[] response;

    public CountryDTO() {
    }

    public CountryDTO(String get, String[] parameter, String[] errors, int result, String[] response) {
        this.get = get;
        this.parameters = parameter;
        this.errors = errors;
        this.results = result;
        this.response = response;
    }

    public String getGet() {
        return get;
    }

    public void setGet(String get) {
        this.get = get;
    }

    public String[] getParameters() {
        return parameters;
    }

    public void setParameters(String[] parameters) {
        this.parameters = parameters;
    }

    public String[] getErrors() {
        return errors;
    }

    public void setErrors(String[] errors) {
        this.errors = errors;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public String[] getResponse() {
        return response;
    }

    public void setResponse(String[] response) {
        this.response = response;
    }
}
