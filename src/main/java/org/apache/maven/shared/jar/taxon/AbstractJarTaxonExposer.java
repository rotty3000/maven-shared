package org.apache.maven.shared.jar.taxon;

/*
 * Copyright 2001-2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.shared.jar.Jar;
import org.codehaus.plexus.logging.AbstractLogEnabled;
import org.codehaus.plexus.logging.Logger;
import org.codehaus.plexus.logging.console.ConsoleLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract Jar Taxon Exposer.
 */
public abstract class AbstractJarTaxonExposer
    extends AbstractLogEnabled
    implements JarTaxonExposer
{
    private Jar jar;

    private List groupIds = null;

    private List artifactIds = null;

    private List versions = null;

    private List names = null;

    private List vendors = null;

    public void initialize()
    {
        jar = null;
        groupIds = null;
        artifactIds = null;
        versions = null;
        names = null;
        vendors = null;
    }

    public Jar getJar()
    {
        return jar;
    }

    public void setJar( Jar jar )
    {
        this.jar = jar;
    }

    private List addUnique( List list, String id )
    {
        if ( id == null )
        {
            return list;
        }

        if ( list == null )
        {
            list = new ArrayList();
        }

        if ( !list.contains( id ) )
        {
            list.add( id );
        }

        return list;
    }

    protected void addGroupId( String id )
    {
        this.groupIds = addUnique( groupIds, id );
    }

    protected void addArtifactId( String id )
    {
        this.artifactIds = addUnique( artifactIds, id );
    }

    protected void addVersion( String id )
    {
        this.versions = addUnique( versions, id );
    }

    protected void addName( String id )
    {
        this.names = addUnique( names, id );
    }

    protected void addVendor( String id )
    {
        this.vendors = addUnique( vendors, id );
    }

    public List getGroupIds()
    {
        return groupIds;
    }

    public List getArtifactIds()
    {
        return artifactIds;
    }

    public List getVersions()
    {
        return versions;
    }

    public List getNames()
    {
        return names;
    }

    public List getVendors()
    {
        return vendors;
    }

    private Logger log;

    protected Logger getLogger()
    {
        if ( log == null )
        {
            log = super.getLogger();
            if ( log == null )
            {
                log = new ConsoleLogger( Logger.LEVEL_DEBUG, AbstractJarTaxonExposer.class.getName() );
            }
        }

        return log;
    }
}
