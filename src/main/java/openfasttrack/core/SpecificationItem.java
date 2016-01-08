package openfasttrack.core;

import java.util.ArrayList;
import java.util.List;

// [impl~requirement_format~1]
public class SpecificationItem
{
    private final SpecificationItemId id;
    private final String description;
    private final String rationale;
    private final String comment;
    private final List<SpecificationItemId> coveredIds;
    private final List<SpecificationItemId> dependOnIds;
    private final List<String> neededArtifactTypes;

    private SpecificationItem(final SpecificationItemId id, final String description,
            final String rationale, final String comment,
            final List<SpecificationItemId> coveredIds, final List<SpecificationItemId> dependOnIds,
            final List<String> neededArtifactTypes)
    {
        this.id = id;
        this.description = description;
        this.rationale = rationale;
        this.comment = comment;
        this.coveredIds = coveredIds;
        this.dependOnIds = dependOnIds;
        this.neededArtifactTypes = neededArtifactTypes;
    }

    public final SpecificationItemId getId()
    {
        return this.id;
    }

    public final String getDescription()
    {
        return this.description;
    }

    public String getRationale()
    {
        return this.rationale;
    }

    public String getComment()
    {
        return this.comment;
    }

    public List<SpecificationItemId> getCoveredIds()
    {
        return this.coveredIds;
    }

    public List<SpecificationItemId> getDependOnIds()
    {
        return this.dependOnIds;
    }

    public List<String> getNeededArtifactTypes()
    {
        return this.neededArtifactTypes;
    }

    public static class Builder
    {
        private SpecificationItemId id;
        private String description;
        private String rationale;
        private String comment;
        private final List<SpecificationItemId> coveredIds;
        private final List<SpecificationItemId> dependOnIds;
        private final List<String> neededArtifactTypes;

        public Builder()
        {
            this.id = null;
            this.description = "";
            this.rationale = "";
            this.comment = "";
            this.coveredIds = new ArrayList<>();
            this.dependOnIds = new ArrayList<>();
            this.neededArtifactTypes = new ArrayList<>();
        }

        public Builder id(final SpecificationItemId id)
        {
            this.id = id;
            return this;
        }

        public Builder title(final String title)
        {
            return this;
        }

        public Builder description(final String description)
        {
            this.description = description;
            return this;
        }

        public Builder rationale(final String rationale)
        {
            this.rationale = rationale;
            return this;
        }

        public Builder comment(final String comment)
        {
            this.comment = comment;
            return this;
        }

        public Builder addCoveredId(final SpecificationItemId coveredId)
        {
            this.coveredIds.add(coveredId);
            return this;
        }

        public Builder addDependOnId(final SpecificationItemId dependOnId)
        {
            this.dependOnIds.add(dependOnId);
            return this;
        }

        public Builder addNeededArtifactType(final String neededArtifactType)
        {
            this.neededArtifactTypes.add(neededArtifactType);
            return this;
        }

        public SpecificationItem build()
        {
            if (this.id == null)
            {
                throw new IllegalStateException("No id given");
            }
            return new SpecificationItem(this.id, this.description, this.rationale, this.comment,
                    this.coveredIds, this.dependOnIds, this.neededArtifactTypes);
        }
    }
}